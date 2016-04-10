package pl.edu.pjwstk.slowka.presentation.presenter.camera

import android.view.SurfaceHolder
import pl.edu.pjwstk.slowka.presentation.presenter.Presenter
import pl.edu.pjwstk.slowka.presentation.ui.camera.CameraActivityView

abstract class CameraActivityPresenter : Presenter<CameraActivityView>() {

    abstract fun cameraSurfaceReady(holder: SurfaceHolder)
    abstract fun cameraSurfaceRefresh()
    abstract fun cameraButtonClicked()
}
