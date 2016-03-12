package pl.rhinoonabus.slowka.camera

import pl.rhinoonabus.slowka.hardware.CameraRepository
import pl.rhinoonabus.slowka.hardware.Previewer
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

    override fun obtainPrevier(): Previewer {
        // TODO such an ugly hack
        return cameraAdapter
    }
}
