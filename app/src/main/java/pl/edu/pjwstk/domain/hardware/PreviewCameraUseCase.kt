package pl.edu.pjwstk.domain.hardware

import android.view.SurfaceHolder
import pl.edu.pjwstk.domain.UseCase
import rx.Observable
import javax.inject.Inject

class PreviewCameraUseCase : UseCase<Unit> {

    private val cameraRepository: CameraRepository
    private val holder: SurfaceHolder?

    @Inject
    constructor(cameraRepository: CameraRepository) : this (cameraRepository, null)

    constructor(cameraRepository: CameraRepository, holder: SurfaceHolder?) {
        this.cameraRepository = cameraRepository
        this.holder = holder;
    }

    fun previewOnto(holder: SurfaceHolder) : PreviewCameraUseCase {
        return PreviewCameraUseCase(cameraRepository, holder)
    }

    override fun perform() : Observable<Unit> {
        if (holder == null) {
            throw AssertionError("Preview must be performed on non null surface holder")
        }
        return Observable.fromCallable {
            cameraRepository.previewCameraOnto(holder)
        }
    }
}
