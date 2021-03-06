package pl.edu.pjwstk.slowka.presentation.ui.recognize

import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.content.StoreImageObjectUseCase
import pl.edu.pjwstk.slowka.domain.information.GetNamesForObjectInImageUseCase
import rx.Observable
import rx.schedulers.Schedulers
import java.io.File

class RecognizeImageModel constructor(
        private val getNamesForObjectInImageUseCase: GetNamesForObjectInImageUseCase,
        private val storeImageObjectUseCase: StoreImageObjectUseCase
    ) {

    fun recognizeObjectInImage(file: File) : Observable<String> {
        return getNamesForObjectInImageUseCase.inImageFrom(file).performAndObserve(Schedulers.io())
    }

    fun storeReadyImageObject(imageObject: ImageObject) : Observable<Boolean> {
        return storeImageObjectUseCase.image(imageObject).performAndObserve(Schedulers.io())
    }
}
