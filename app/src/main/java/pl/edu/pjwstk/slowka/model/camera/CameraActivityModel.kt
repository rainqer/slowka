package pl.edu.pjwstk.slowka.model.camera

import android.view.SurfaceHolder
import pl.edu.pjwstk.slowka.dagger.camera.CameraActivityScope
import pl.edu.pjwstk.slowka.presenter.camera.CameraActivityPresenterImpl
import pl.rhinoonabus.slowka.camera.CameraAdapter
import pl.rhinoonabus.slowka.hardware.FetchPreviewerUseCase
import pl.rhinoonabus.slowka.hardware.LaunchCameraUseCase
import pl.rhinoonabus.slowka.hardware.StopCameraUseCase
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.subscriptions.Subscriptions
import javax.inject.Inject

@CameraActivityScope
class CameraActivityModel @Inject constructor(
        val launchCameraUseCase: LaunchCameraUseCase,
        val stopCameraUseCase: StopCameraUseCase,
        val obtainPreviewerUseCase: FetchPreviewerUseCase) {

    protected var cameraFrameSubscription = Subscriptions.unsubscribed()
    private lateinit var cameraActivityPresenter: CameraActivityPresenterImpl

    fun startProcessingPreview(cameraActivityPresenter: CameraActivityPresenterImpl) {
        this.cameraActivityPresenter = cameraActivityPresenter
        launchCameraUseCase.perform().subscribe { frames ->
            observeFrames(frames)
        }
    }

    fun stopProcessingPreview() {
        cameraFrameSubscription.unsubscribe()
        stopCameraUseCase.performSync()
    }

    private fun observeFrames(cameraFrameObservable: Observable<ByteArray>) {
        cameraFrameSubscription.unsubscribe()
        cameraFrameSubscription = cameraFrameObservable
                .onBackpressureLatest()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { extractedDocument ->
                }
    }

    fun cameraSurfaceReady(holder: SurfaceHolder) {
        obtainPreviewerUseCase.perform().subscribe { previewer ->
            //TODO such hack :( Android made me do it
            (previewer as CameraAdapter).previewOn(holder)
        }
    }

    fun cameraSurfaceRefresh() {
        launchCameraUseCase.perform().subscribe { frames ->
            observeFrames(frames)
        }
    }
}
