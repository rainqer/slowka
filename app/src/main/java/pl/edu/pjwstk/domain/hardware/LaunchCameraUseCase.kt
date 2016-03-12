package pl.edu.pjwstk.domain.hardware

import pl.edu.pjwstk.domain.UseCase
import rx.Observable
import javax.inject.Inject

class LaunchCameraUseCase : UseCase<Observable<ByteArray>> {

    private val cameraRepository: CameraRepository

    @Inject
    constructor(cameraRepository: CameraRepository) {
        this.cameraRepository = cameraRepository
    }

    override fun perform() : Observable<Observable<ByteArray>> {
        return Observable.fromCallable {
            cameraRepository.observeFrames()
        }
    }
}
