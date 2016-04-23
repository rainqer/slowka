package pl.edu.pjwstk.slowka.domain.hardware

import pl.edu.pjwstk.slowka.domain.UseCase

class GetCurrentCameraFrameUseCase : UseCase<CameraFrame> {

    private val cameraRepository: CameraRepository

    constructor(cameraRepository: CameraRepository) {
        this.cameraRepository = cameraRepository
    }

    override fun perform() : CameraFrame {
        return cameraRepository.getCurrentFrame()
    }
}
