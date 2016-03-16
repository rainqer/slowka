package pl.edu.pjwstk.presentation.presenter.camera

import android.view.SurfaceHolder
import pl.edu.pjwstk.presenter.ActivityPresenter
import pl.edu.pjwstk.presentation.ui.camera.CameraActivityView
import java.io.File

interface CameraActivityPresenter : ActivityPresenter<CameraActivityView> {

    fun cameraSurfaceReady(holder: SurfaceHolder)
    fun cameraSurfaceRefresh()
    fun cameraButtonClicked()
    fun onCameraFramedSaved(file: File)
    fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray)
}
