package pl.edu.pjwstk.slowka.domain.hardware

import pl.edu.pjwstk.slowka.domain.UseCase
import javax.inject.Inject

class GetCurrentCameraFrameUseCase : UseCase<CameraFrame> {

    private val cameraRepository: CameraRepository

    @Inject
    constructor(cameraRepository: CameraRepository) {
        this.cameraRepository = cameraRepository
    }

    override fun perform() : CameraFrame {
        return cameraRepository.getCurrentFrame()
    }
}
