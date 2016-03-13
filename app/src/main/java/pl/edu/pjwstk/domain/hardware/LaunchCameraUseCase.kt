package pl.edu.pjwstk.domain.hardware

import pl.edu.pjwstk.domain.UseCase
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
