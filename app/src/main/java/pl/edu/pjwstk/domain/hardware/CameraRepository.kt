package pl.edu.pjwstk.domain.hardware

import android.view.SurfaceHolder

interface CameraRepository {

    fun startCapturingCameraFrames()
    fun getCurrentFrame() : CameraFrame
    fun stop()
    fun previewCameraOnto(holder: SurfaceHolder)
}
