package pl.edu.pjwstk.presentation.model.camera

import android.view.SurfaceHolder
import pl.edu.pjwstk.domain.file.SaveCurrentCameraFrameUseCase
import pl.edu.pjwstk.domain.hardware.PreviewCameraUseCase
import pl.edu.pjwstk.domain.hardware.LaunchCameraUseCase
import pl.edu.pjwstk.domain.hardware.StopCameraUseCase
import pl.edu.pjwstk.presentation.dagger.camera.CameraActivityScope
import pl.edu.pjwstk.presentation.presenter.camera.CameraActivityPresenterImpl
import rx.Observable
import rx.schedulers.Schedulers
import java.io.File
import javax.inject.Inject

@CameraActivityScope
class CameraActivityModel @Inject constructor(
        val launchCameraUseCase: LaunchCameraUseCase,
        val stopCameraUseCase: StopCameraUseCase,
        val previewerCameraUseCase: PreviewCameraUseCase,
        val saveCurrentCameraFrameUseCase: SaveCurrentCameraFrameUseCase) {

    private lateinit var cameraActivityPresenter: CameraActivityPresenterImpl

    fun startProcessingPreview(cameraActivityPresenter: CameraActivityPresenterImpl) {
        this.cameraActivityPresenter = cameraActivityPresenter
        launchCameraUseCase.performAsync()
    }

    fun stopProcessingPreview() {
        stopCameraUseCase.performAsync()
    }

    fun cameraSurfaceReady(holder: SurfaceHolder) {
        previewerCameraUseCase.previewOnto(holder).performAsync()
    }

    fun cameraSurfaceRefresh() {
        launchCameraUseCase.performAsync()
    }

    fun saveCurrentCameraFrameToFile() : Observable<File> {
        return saveCurrentCameraFrameUseCase.performAndObserve(Schedulers.io())
    }
}
