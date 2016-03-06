package pl.edu.pjwstk.slowka.presenter.camera

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.SurfaceHolder
import pl.edu.pjwstk.presenter.ActivityPresenter
import pl.edu.pjwstk.slowka.model.camera.CameraActivityModelImpl
import pl.edu.pjwstk.slowka.ui.camera.CameraActivityView

class CameraActivityPresenter constructor(val cameraActivityModel: CameraActivityModelImpl) : ActivityPresenter<CameraActivityView> {

    private val CAMERA_REQUEST_PERMISSION: Int = 123;
    private lateinit var cameraActivityView: CameraActivityView
    private lateinit var activity: Activity

    override fun attach(cameraActivityView: CameraActivityView,
                        activity: Activity,
                        savedInstanceState: Bundle?) {
        this.cameraActivityView = cameraActivityView
        this.activity = activity
        cameraActivityView.setupCameraPreviewRatio(Ratio.FOUR_TO_THREE)
    }

    override fun resume() {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            activity.requestPermissions(arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_PERMISSION)
        } else {
            startCameraComponents()
        }
    }

    override fun pause() {
        cameraActivityModel.stopProcessingPreview()
    }

    fun cameraSurfaceReady(holder: SurfaceHolder) {
        cameraActivityModel.cameraSurfaceReady(holder)
    }

    fun cameraSurfaceRefresh() {
        cameraActivityModel.cameraSurfaceRefresh()
    }

    fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        if (requestCode == CAMERA_REQUEST_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCameraComponents()
            }
        }
    }

    private fun startCameraComponents() {
        cameraActivityModel.startProcessingPreview(this)
        cameraActivityView.setupSurfaceForCameraAndUnblock()
    }
}
