package pl.edu.pjwstk.repository.camera

import android.view.SurfaceHolder
import pl.edu.pjwstk.domain.hardware.CameraRepository
import rx.android.schedulers.AndroidSchedulers
import rx.subscriptions.Subscriptions
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AndroidCameraRepository : CameraRepository {

    private val cameraAdapter: CameraAdapter
    private var currentFrame : ByteArray? = null
    private var cameraFrameSubscription = Subscriptions.unsubscribed()

    @Inject
    constructor(cameraAdapter: CameraAdapter) {
        this.cameraAdapter = cameraAdapter
    }

    override fun startCapturingCameraFrames() {
        cameraFrameSubscription.unsubscribe()
        cameraFrameSubscription = cameraAdapter.start()
                .onBackpressureLatest()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { frame ->
                    currentFrame = frame
                }
    }

    override fun getCurrentFrame() : ByteArray? {
        return currentFrame
    }

    override fun stop() {
        cameraFrameSubscription.unsubscribe()
        cameraAdapter.stop()
    }

    override fun previewCameraOnto(holder: SurfaceHolder) {
        return cameraAdapter.previewOn(holder)
    }
}
