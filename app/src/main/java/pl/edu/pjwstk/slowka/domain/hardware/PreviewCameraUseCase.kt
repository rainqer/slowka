package pl.edu.pjwstk.slowka.domain.hardware

import android.view.SurfaceHolder
import pl.edu.pjwstk.slowka.domain.UseCase
import javax.inject.Inject

class PreviewCameraUseCase : UseCase<Unit> {

    private val cameraRepository: CameraRepository
    private val holder: SurfaceHolder?

    @Inject
    constructor(cameraRepository: CameraRepository) : this (cameraRepository, null)

    private constructor(cameraRepository: CameraRepository, holder: SurfaceHolder?) {
        this.cameraRepository = cameraRepository
        this.holder = holder;
    }

    fun previewOnto(holder: SurfaceHolder) : PreviewCameraUseCase {
        return PreviewCameraUseCase(cameraRepository, holder)
    }

    override fun perform() {
        if (holder == null) {
            throw AssertionError("Preview must be performed on non null surface holder")
        }
        cameraRepository.previewCameraOnto(holder)
    }
}
