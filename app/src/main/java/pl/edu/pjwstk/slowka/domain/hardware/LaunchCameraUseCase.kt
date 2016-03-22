package pl.edu.pjwstk.slowka.domain.hardware

import pl.edu.pjwstk.slowka.domain.UseCase
import javax.inject.Inject

class LaunchCameraUseCase : UseCase<Unit> {

    private val cameraRepository: CameraRepository

    @Inject
    constructor(cameraRepository: CameraRepository) {
        this.cameraRepository = cameraRepository
    }

    override fun perform() {
        return cameraRepository.startCapturingCameraFrames()
    }
}
