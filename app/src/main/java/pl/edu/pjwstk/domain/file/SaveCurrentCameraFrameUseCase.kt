package pl.edu.pjwstk.domain.file

import pl.edu.pjwstk.domain.UseCase
import pl.edu.pjwstk.domain.hardware.CameraRepository
import java.io.File
import javax.inject.Inject

class SaveCurrentCameraFrameUseCase : UseCase<File> {

    private val saveCameraFrameUseCase: SaveCameraFrameUseCase
    private val cameraRepository: CameraRepository

    @Inject
    constructor(cameraRepository: CameraRepository, saveCameraFrameUseCase: SaveCameraFrameUseCase) {
        this.cameraRepository = cameraRepository
        this.saveCameraFrameUseCase = saveCameraFrameUseCase
    }

    override fun perform(): File {
        return saveCameraFrameUseCase.cameraFrame(cameraRepository.getCurrentFrame()).perform()
    }
}
