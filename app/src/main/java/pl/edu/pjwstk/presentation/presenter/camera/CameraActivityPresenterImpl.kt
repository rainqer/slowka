package pl.edu.pjwstk.presentation.presenter.camera

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.SurfaceHolder
import pl.edu.pjwstk.presentation.model.camera.CameraActivityModel
import pl.edu.pjwstk.presentation.ui.camera.CameraActivityView
import pl.edu.pjwstk.presentation.ui.recognize.RecognizeImageActivity

class CameraActivityPresenterImpl constructor(val cameraActivityModel: CameraActivityModel)
        : CameraActivityPresenter() {

    private val CAMERA_REQUEST_PERMISSION: Int = 123;
    private val WRITE_TO_SD_CARD_REQUEST_PERMISSION: Int = 124;

    override fun attach(activityView: CameraActivityView,
                        activity: Activity,
                        savedInstanceState: Bundle?) {
        super.attach(activityView, activity, savedInstanceState)
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

    override fun cameraSurfaceReady(holder: SurfaceHolder) {
        cameraActivityModel.cameraSurfaceReady(holder)
    }

    override fun cameraSurfaceRefresh() {
        cameraActivityModel.cameraSurfaceRefresh()
    }

    override fun cameraButtonClicked() {
        if (permissionGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            proceedToRecogniseScreenWithFileSaved()
        } else {
            requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, WRITE_TO_SD_CARD_REQUEST_PERMISSION)
        }
    }

    private fun proceedToRecogniseScreenWithFileSaved() {
        cameraActivityModel.saveCurrentCameraFrameToFile().subscribe { file ->
            startActivity(RecognizeImageActivity.createIntent(presentedActivity, file))
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (requestCode == CAMERA_REQUEST_PERMISSION) {
                // NO OP
            } else if (requestCode == WRITE_TO_SD_CARD_REQUEST_PERMISSION){
                proceedToRecogniseScreenWithFileSaved()
            }
        }
    }

    private fun startCameraComponents() {
        cameraActivityModel.startProcessingPreview(this)
        presentedView.setupSurfaceForCameraAndUnblock()
    }
}
