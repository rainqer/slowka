package pl.edu.pjwstk.slowka.domain.file

import android.graphics.Bitmap
import pl.edu.pjwstk.slowka.domain.hardware.CameraFrame
import java.io.File

interface FileRepository {

    fun saveImageToFile(cameraFrame : CameraFrame) : File

    fun saveBitmapToFile(bitmap: Bitmap, destinationFile: File): File
}
