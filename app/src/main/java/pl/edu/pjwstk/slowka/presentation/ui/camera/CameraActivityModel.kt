package pl.edu.pjwstk.slowka.presentation.ui.camera

import android.view.SurfaceHolder
import pl.edu.pjwstk.slowka.domain.file.SaveCurrentCameraFrameUseCase
import pl.edu.pjwstk.slowka.domain.hardware.LaunchCameraUseCase
import pl.edu.pjwstk.slowka.domain.hardware.PreviewCameraUseCase
import pl.edu.pjwstk.slowka.domain.hardware.StopCameraUseCase
import rx.Observable
import rx.schedulers.Schedulers
import java.io.File

class CameraActivityModel constructor(
        private val launchCameraUseCase: LaunchCameraUseCase,
        private val stopCameraUseCase: StopCameraUseCase,
        private val previewerCameraUseCase: PreviewCameraUseCase,
        private val saveCurrentCameraFrameUseCase: SaveCurrentCameraFrameUseCase) {

    private lateinit var cameraActivityPresenter: CameraActivityPresenter

    fun startProcessingPreview(cameraActivityPresenter: CameraActivityPresenter) {
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
