package pl.edu.pjwstk.slowka.domain.file

import pl.edu.pjwstk.slowka.domain.UseCase
import pl.edu.pjwstk.slowka.domain.hardware.CameraFrame
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivity
import pl.edu.pjwstk.slowka.repository.file.MediaScannerUpdater
import rx.schedulers.Schedulers
import java.io.File
import javax.inject.Inject

class SaveCameraFrameUseCase : UseCase<File> {

    private val fileRepository: FileRepository
    private val cameraFrame: CameraFrame?
    private val mediaScannerUpdater: MediaScannerUpdater

    @Inject
    constructor(fileRepository: FileRepository, mediaScannerUpdater: MediaScannerUpdater)
        : this (fileRepository, mediaScannerUpdater, null)

    private constructor(fileRepository: FileRepository, mediaScannerUpdater: MediaScannerUpdater, cameraFrame: CameraFrame?) {
        this.mediaScannerUpdater = mediaScannerUpdater
        this.fileRepository = fileRepository
        this.cameraFrame = cameraFrame
    }

    fun cameraFrame(cameraFrame: CameraFrame) : SaveCameraFrameUseCase {
        return SaveCameraFrameUseCase(fileRepository, mediaScannerUpdater, cameraFrame)
    }

    override fun perform() : File {
        if (cameraFrame == null) {
            throw AssertionError("Camera Frame not specified")
        }
        val file = fileRepository.saveImageToFile(cameraFrame)
        mediaScannerUpdater.update(file)
        return file
    }
}
