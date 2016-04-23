package pl.edu.pjwstk.slowka.presentation.ui.camera

import pl.edu.pjwstk.slowka.presentation.ui.camera.Ratio

interface CameraActivityView {

    fun setupCameraPreviewRatio(ratio: Ratio)

    fun setupSurfaceForCameraAndUnblock()

}