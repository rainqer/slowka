package pl.edu.pjwstk.presentation.ui.camera

import pl.edu.pjwstk.presentation.presenter.camera.Ratio

interface CameraActivityView {

    fun setupCameraPreviewRatio(ratio: Ratio)

    fun setupSurfaceForCameraAndUnblock()

}