package pl.edu.pjwstk.slowka.repository.file

import android.graphics.Bitmap
import pl.edu.pjwstk.slowka.domain.file.FileRepository
import pl.edu.pjwstk.slowka.domain.hardware.CameraFrame
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AndroidFileRepository : FileRepository {

    @Inject
    constructor()

    override fun saveImageToFile(cameraFrame: CameraFrame) : File {
        return ByteArrayToFileSavingProcess(cameraFrame.frame, "aaa", cameraFrame.dimensions).save()
    }

    override fun saveBitmapToFile(bitmap: Bitmap, destinationFile: File): File {
        return BitmapToFileSavingProcess(bitmap, destinationFile.name).save()
    }
}
