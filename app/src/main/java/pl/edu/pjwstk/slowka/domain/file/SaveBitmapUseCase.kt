package pl.edu.pjwstk.slowka.domain.file

import android.graphics.Bitmap
import pl.edu.pjwstk.slowka.domain.UseCase
import pl.edu.pjwstk.slowka.domain.hardware.CameraFrame
import pl.edu.pjwstk.slowka.repository.file.MediaScannerUpdater
import java.io.File
import javax.inject.Inject

class SaveBitmapUseCase : UseCase<File> {

    private val fileRepository: FileRepository
    private val mediaScannerUpdater: MediaScannerUpdater
    private val bitmap: Bitmap?
    private val destinationFile: File?

    @Inject
    constructor(fileRepository: FileRepository,
                mediaScannerUpdater: MediaScannerUpdater)

        : this (fileRepository, mediaScannerUpdater, null)

    private constructor(fileRepository: FileRepository,
                        mediaScannerUpdater: MediaScannerUpdater,
                        bitmap: Bitmap?)

    : this (fileRepository, mediaScannerUpdater, bitmap, null)

    private constructor(fileRepository: FileRepository,
                        mediaScannerUpdater: MediaScannerUpdater,
                        bitmap: Bitmap?,
                        file: File?) {

        this.mediaScannerUpdater = mediaScannerUpdater
        this.fileRepository = fileRepository
        this.bitmap = bitmap
        this.destinationFile = file
    }

    fun bitmap(bitmap: Bitmap) : SaveBitmapUseCase {
        return SaveBitmapUseCase(fileRepository, mediaScannerUpdater, bitmap, destinationFile)
    }

    fun toFile(file: File) : SaveBitmapUseCase {
        return SaveBitmapUseCase(fileRepository, mediaScannerUpdater, bitmap, file)
    }

    override fun perform() : File {
        if (bitmap == null) {
            throw AssertionError("Bitmap not specified")
        }
        if (destinationFile == null) {
            throw AssertionError("Destination file not specified")
        }
        val file = fileRepository.saveBitmapToFile(bitmap, destinationFile)
        mediaScannerUpdater.update(file)
        return file
    }
}
