package pl.edu.pjwstk.presentation.presenter.camera

import android.view.SurfaceHolder
import pl.edu.pjwstk.presenter.ActivityPresenter
import pl.edu.pjwstk.presentation.ui.camera.CameraActivityView

interface CameraActivityPresenter : ActivityPresenter<CameraActivityView> {

    fun cameraSurfaceReady(holder: SurfaceHolder)
    fun cameraSurfaceRefresh()
    fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray)
}
