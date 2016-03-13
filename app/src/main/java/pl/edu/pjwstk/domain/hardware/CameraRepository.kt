package pl.edu.pjwstk.domain.hardware

import android.view.SurfaceHolder

interface CameraRepository {

    fun startCapturingCameraFrames()
    fun getCurrentFrame() : ByteArray?
    fun stop()
    fun previewCameraOnto(holder: SurfaceHolder)
}
