package pl.edu.pjwstk.slowka.repository.camera

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Rect
import android.hardware.Camera
import android.os.Handler
import android.view.SurfaceHolder
import rx.Observable
import javax.inject.Inject

class CameraAdapter {

    @Inject
    constructor()

    companion object {
        private val ROTATION_DEGREE = 90
        private val MIN_AUTO_FOCUS_COUNT = 1
        private val NEXT_FOCUS_DELAY = 1000L
        private val FOCUS_MODE = "macro"
        private val ORIENTATION_KEY = "orientation"
        private val ORIENTATION_VALUE = "landscape"
        private val FLASH_ON = "torch"
        private val FLASH_OFF = "off"
    }

    protected lateinit var context: Context
    
    private val isFocusedOnTarget: Boolean
        get() = focusedCountInRow >= CameraAdapter.Companion.MIN_AUTO_FOCUS_COUNT
    private var cameraSizeRect: Rect = Rect(0, 0, 0, 0)
    val cameraDimensions: Rect
        get() = cameraSizeRect
    private var isFlashActive = false
    private var focusedCountInRow: Int = 0
    private var active = false
    private var initialized = false

    private val camera: Camera
        get() = cameraHandle?:throw AssertionError("Camera was not initialized correctly")
    private var cameraHandle: Camera? = null

    @Synchronized
    fun start(): Observable<ByteArray> {
        if (!initialized) {
            initCamera()
        }
        camera.startPreview()
        active = true
        refreshPreviewSizeRect()
        return getObservableOnCameraFrames()
    }

    private fun getObservableOnCameraFrames(): Observable<ByteArray> {
        return Observable.create { subscriber ->
            camera.setPreviewCallback { cameraFrame, camera ->
                if (!subscriber.isUnsubscribed && isFocusedOnTarget) {
                    subscriber.onNext(cameraFrame)
                }
            }
        }
    }

    private fun initCamera() {
        cameraHandle = Camera.open()
        configure(CameraRatio.FOUR_TO_THREE)
        initialized = true
    }

    @Synchronized
    fun stop() {
        if (active) {
            active = false
            isFlashActive = false
            initialized = false
            tearDownCamera()
        }
    }

    private fun tearDownCamera() {
        camera.stopPreview()
        camera.setPreviewCallback(null)
        camera.release()
        cameraHandle = null
    }

    @Synchronized
    fun previewOn(surfaceHolder: SurfaceHolder) {
        camera.setPreviewDisplay(surfaceHolder)
        autoFocusOnTargetAndRepeat()
    }

    private fun configure(ratio: CameraRatio) {
        val params = camera.parameters
        configPreviewRatioAndSize(params, ratio)
        configPictureRatioAndSize(params, ratio)
        configRotation(params)
        configFocusMode(params)
        configOrientation(params)
        camera.parameters = params
    }

    fun hasFlash(): Boolean {
        return context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)
    }

    fun toggleFlash() {
        isFlashActive = !isFlashActive
        if (isFlashActive) {
            setFlashModeIfCameraStillAvailable(CameraAdapter.Companion.FLASH_ON)
        } else {
            setFlashModeIfCameraStillAvailable(CameraAdapter.Companion.FLASH_OFF)
        }
    }

    private fun setFlashModeIfCameraStillAvailable(mode: String) {
        val params = cameraHandle?.parameters
        params?.flashMode = mode
        cameraHandle?.parameters = params
    }

    private fun configOrientation(params: Camera.Parameters) {
        params.set(CameraAdapter.Companion.ORIENTATION_KEY, CameraAdapter.Companion.ORIENTATION_VALUE)
    }

    private fun configFocusMode(params: Camera.Parameters) {
        params.focusMode = CameraAdapter.Companion.FOCUS_MODE
    }

    private fun configRotation(params: Camera.Parameters) {
        params.setRotation(CameraAdapter.Companion.ROTATION_DEGREE)
        camera.setDisplayOrientation(CameraAdapter.Companion.ROTATION_DEGREE)
    }

    private fun configPreviewRatioAndSize(params: Camera.Parameters, ratio: CameraRatio) {
        val selected = ratio.extractFourByThreeSize(camera.parameters?.supportedPreviewSizes)
        params.setPreviewSize(selected.width, selected.height)
    }

    private fun configPictureRatioAndSize(params: Camera.Parameters, ratio: CameraRatio) {
        val selected = ratio.extractFourByThreeSize(camera.parameters?.supportedPictureSizes)
        params.setPictureSize(selected.width, selected.height)
    }

    private fun autoFocusOnTargetAndRepeat() {
        camera.autoFocus { wasSuccessful, camera ->
            if (wasSuccessful) {
                ++focusedCountInRow
            } else {
                focusedCountInRow = 0
            }
            repeatAutoFocusOnTargetWithDelay()
        }
    }

    private fun repeatAutoFocusOnTargetWithDelay() {
        Handler().postDelayed({
            if (active) {
                camera.cancelAutoFocus()
                autoFocusOnTargetAndRepeat()
            }
        }, CameraAdapter.Companion.NEXT_FOCUS_DELAY)
    }

    private fun refreshPreviewSizeRect() {
        val previewSize = camera.parameters?.previewSize?:throw AssertionError("could not read camera size")
        cameraSizeRect = Rect(0, 0, previewSize.width, previewSize.height)
    }
}