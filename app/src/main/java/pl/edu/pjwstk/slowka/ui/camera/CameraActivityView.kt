package pl.edu.pjwstk.slowka.ui.camera

import pl.edu.pjwstk.slowka.presenter.camera.Ratio

interface CameraActivityView {

    fun setupCameraPreviewRatio(ratio: Ratio)

    fun setupSurfaceForCameraAndUnblock()

}