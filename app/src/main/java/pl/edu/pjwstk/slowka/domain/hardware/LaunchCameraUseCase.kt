package pl.edu.pjwstk.slowka.domain.hardware

import pl.edu.pjwstk.slowka.domain.UseCase

class LaunchCameraUseCase : UseCase<Unit> {

    private val cameraRepository: CameraRepository

    constructor(cameraRepository: CameraRepository) {
        this.cameraRepository = cameraRepository
    }

    override fun perform() {
        return cameraRepository.startCapturingCameraFrames()
    }
}
