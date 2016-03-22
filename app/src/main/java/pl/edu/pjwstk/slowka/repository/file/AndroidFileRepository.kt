package pl.edu.pjwstk.slowka.repository.file

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
        return ImageFileSavingProcess(cameraFrame.frame, "aaa", cameraFrame.dimensions).save()
    }
}
