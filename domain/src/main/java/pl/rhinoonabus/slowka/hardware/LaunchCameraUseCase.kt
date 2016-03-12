package pl.rhinoonabus.slowka.hardware

import pl.rhinoonabus.slowka.UseCase
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
