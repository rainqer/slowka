package pl.edu.pjwstk.presentation.model.camera

import android.view.SurfaceHolder
import pl.edu.pjwstk.domain.hardware.PreviewCameraUseCase
import pl.edu.pjwstk.domain.hardware.LaunchCameraUseCase
import pl.edu.pjwstk.domain.hardware.StopCameraUseCase
import pl.edu.pjwstk.presentation.dagger.camera.CameraActivityScope
import pl.edu.pjwstk.presentation.presenter.camera.CameraActivityPresenterImpl
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.subscriptions.Subscriptions
import javax.inject.Inject

@CameraActivityScope
class CameraActivityModel @Inject constructor(
        val launchCameraUseCase: LaunchCameraUseCase,
        val stopCameraUseCase: StopCameraUseCase,
        val obtainPreviewerUseCase: PreviewCameraUseCase) {

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
        obtainPreviewerUseCase.previewOnto(holder).performSync()
    }

    fun cameraSurfaceRefresh() {
        launchCameraUseCase.perform().subscribe { frames ->
            observeFrames(frames)
        }
    }
}
