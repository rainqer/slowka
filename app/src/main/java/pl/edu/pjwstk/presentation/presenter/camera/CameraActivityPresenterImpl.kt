package pl.edu.pjwstk.presentation.presenter.camera

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.SurfaceHolder
import android.widget.Toast
import pl.edu.pjwstk.presentation.model.camera.CameraActivityModel
import pl.edu.pjwstk.presentation.ui.camera.CameraActivityView
import java.io.File

class CameraActivityPresenterImpl constructor(val cameraActivityModel: CameraActivityModel)
        : CameraActivityPresenter {

    private val CAMERA_REQUEST_PERMISSION: Int = 123;
    private lateinit var cameraActivityView: CameraActivityView
    private lateinit var activity: Activity

    override fun attach(activityView: CameraActivityView,
                        activity: Activity,
                        savedInstanceState: Bundle?) {
        this.cameraActivityView = activityView
        this.activity = activity
        cameraActivityView.setupCameraPreviewRatio(Ratio.FOUR_TO_THREE)
    }

    override fun resume() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB
                && ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            activity.requestPermissions(arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_PERMISSION)
        } else {
            startCameraComponents()
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
        cameraActivityModel.saveCurrentCameraFrameToFile()
    }

    override fun onCameraFramedSaved(file: File) {
        Toast.makeText(activity, file.absolutePath, Toast.LENGTH_LONG).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
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
