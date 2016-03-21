package pl.edu.pjwstk.presentation.presenter.camera

import android.view.SurfaceHolder
import pl.edu.pjwstk.presentation.presenter.ActivityPresenter
import pl.edu.pjwstk.presentation.ui.camera.CameraActivityView

abstract class CameraActivityPresenter : ActivityPresenter<CameraActivityView>() {

    abstract fun cameraSurfaceReady(holder: SurfaceHolder)
    abstract fun cameraSurfaceRefresh()
    abstract fun cameraButtonClicked()
}
