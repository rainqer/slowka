package pl.edu.pjwstk.presentation.model.camera

import android.view.SurfaceHolder
import pl.edu.pjwstk.domain.hardware.PreviewCameraUseCase
import pl.edu.pjwstk.domain.hardware.LaunchCameraUseCase
import pl.edu.pjwstk.domain.hardware.StopCameraUseCase
import pl.edu.pjwstk.presentation.dagger.camera.CameraActivityScope
import pl.edu.pjwstk.presentation.presenter.camera.CameraActivityPresenterImpl
import javax.inject.Inject

@CameraActivityScope
class CameraActivityModel @Inject constructor(
        val launchCameraUseCase: LaunchCameraUseCase,
        val stopCameraUseCase: StopCameraUseCase,
        val obtainPreviewerUseCase: PreviewCameraUseCase) {

    private lateinit var cameraActivityPresenter: CameraActivityPresenterImpl

    fun startProcessingPreview(cameraActivityPresenter: CameraActivityPresenterImpl) {
        this.cameraActivityPresenter = cameraActivityPresenter
        launchCameraUseCase.performAsync()
    }

    fun stopProcessingPreview() {
        stopCameraUseCase.performAsync()
    }

    fun cameraSurfaceReady(holder: SurfaceHolder) {
        obtainPreviewerUseCase.previewOnto(holder).performAsync()
    }

    fun cameraSurfaceRefresh() {
        launchCameraUseCase.performAsync()
    }
}
