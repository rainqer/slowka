package pl.rhinoonabus.slowka.hardware

import pl.rhinoonabus.slowka.UseCase
import rx.Observable
import javax.inject.Inject

class FetchPreviewerUseCase : UseCase<Previewer> {

    private val cameraRepository: CameraRepository

    @Inject
    constructor(cameraRepository: CameraRepository) {
        this.cameraRepository = cameraRepository
    }

    override fun perform() : Observable<Previewer> {
        return Observable.fromCallable {
            cameraRepository.obtainPrevier()
        }
    }
}
