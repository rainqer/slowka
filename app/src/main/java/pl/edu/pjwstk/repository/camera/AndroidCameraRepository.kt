package pl.edu.pjwstk.repository.camera

import android.view.SurfaceHolder
import pl.edu.pjwstk.domain.hardware.CameraRepository
import rx.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AndroidCameraRepository : CameraRepository {
    val cameraAdapter: CameraAdapter

    @Inject
    constructor(cameraAdapter: CameraAdapter) {
        this.cameraAdapter = cameraAdapter
    }

    override fun observeFrames(): Observable<ByteArray> {
        return cameraAdapter.start()
    }

    override fun stop() {
        cameraAdapter.stop()
    }

    override fun previewCameraOnto(holder: SurfaceHolder) {
        return cameraAdapter.previewOn(holder)
    }
}
