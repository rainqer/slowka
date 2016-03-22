package pl.edu.pjwstk.slowka.domain.file

import pl.edu.pjwstk.slowka.domain.hardware.CameraFrame
import java.io.File

interface FileRepository {

    fun saveImageToFile(cameraFrame : CameraFrame) : File
}
