package pl.edu.pjwstk.slowka.presentation.ui.camera

import android.view.SurfaceHolder
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.camera.CameraActivityView

abstract class CameraActivityPresenter : ActivityPresenter<CameraActivityView>() {

    abstract fun cameraSurfaceReady(holder: SurfaceHolder)
    abstract fun cameraSurfaceRefresh()
    abstract fun cameraButtonClicked()
}
