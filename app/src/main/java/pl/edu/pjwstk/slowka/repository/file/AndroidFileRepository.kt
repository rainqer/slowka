package pl.edu.pjwstk.slowka.repository.file

import android.graphics.Bitmap
import pl.edu.pjwstk.slowka.domain.file.FileRepository
import pl.edu.pjwstk.slowka.domain.hardware.CameraFrame
import pl.edu.pjwstk.slowka.domain.tools.DateFileNameGenerator
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AndroidFileRepository @Inject constructor(private val fileNameGenerator: DateFileNameGenerator)
    : FileRepository {

    override fun saveImageToFile(cameraFrame: CameraFrame) : File {
        return ByteArrayToFileSavingProcess(cameraFrame.frame, fileNameGenerator.generate(), cameraFrame.dimensions).save()
    }

    override fun saveBitmapToFile(bitmap: Bitmap, destinationFile: File): File {
        return BitmapToFileSavingProcess(bitmap, destinationFile.name).save()
    }
}
