package pl.edu.pjwstk.domain.hardware

import android.view.SurfaceHolder
import rx.Observable

interface CameraRepository {

    fun observeFrames() : Observable<ByteArray>
    fun stop()
    fun previewCameraOnto(holder: SurfaceHolder)
}
