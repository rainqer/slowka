package pl.edu.pjwstk.domain.file

import pl.edu.pjwstk.domain.hardware.CameraFrame
import java.io.File

interface FileRepository {

    fun saveImageToFile(cameraFrame : CameraFrame) : File
}
