package pl.edu.pjwstk.slowka.presentation.ui.camera

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.SurfaceHolder
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.crop.CropImageActivity

class CameraActivityPresenter constructor(val cameraActivityModel: CameraActivityModel)
        : ActivityPresenter<CameraActivityView>() {

    private val CAMERA_REQUEST_PERMISSION: Int = 123;
    private val WRITE_TO_SD_CARD_REQUEST_PERMISSION: Int = 124;

    override fun attach(view: CameraActivityView,
                        activity: FragmentActivity,
                        savedInstanceState: Bundle?) {

        super.attach(view, activity, savedInstanceState)
        presentedView.setupCameraPreviewRatio(Ratio.FOUR_TO_THREE)
    }

    override fun resume() {
        if (permissionGranted(Manifest.permission.CAMERA)) {
            startCameraComponents()
        } else {
            requestPermission(Manifest.permission.CAMERA, CAMERA_REQUEST_PERMISSION)
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

    fun cameraButtonClicked() {
        if (permissionGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            proceedToCropScreenWithFileSaved()
        } else {
            requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, WRITE_TO_SD_CARD_REQUEST_PERMISSION)
        }
    }

    private fun proceedToCropScreenWithFileSaved() {
        cameraActivityModel.saveCurrentCameraFrameToFile().subscribe { file ->
            startActivity(CropImageActivity.createIntent(presentedActivity, file))
            presentedActivity.finish()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (requestCode == CAMERA_REQUEST_PERMISSION) {
                // NO OP
            } else if (requestCode == WRITE_TO_SD_CARD_REQUEST_PERMISSION){
                proceedToCropScreenWithFileSaved()
            }
        }
    }

    private fun startCameraComponents() {
        cameraActivityModel.startProcessingPreview(this)
        presentedView.setupSurfaceForCameraAndUnblock()
    }
}
