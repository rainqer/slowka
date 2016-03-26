package pl.edu.pjwstk.slowka.presentation.model.recognize

import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.information.GetNamesForObjectInImageUseCase
import pl.edu.pjwstk.slowka.domain.content.StoreImageObjectUseCase
import pl.edu.pjwstk.slowka.presentation.dagger.recognize.RecognizeImageActivityScope
import rx.Observable
import rx.schedulers.Schedulers
import java.io.File
import javax.inject.Inject

@RecognizeImageActivityScope
class RecognizeImageModel @Inject constructor(
        private val getNamesForObjectInImageUseCase: GetNamesForObjectInImageUseCase
        private val storeImageObjectUseCase: StoreImageObjectUseCase
    ) {

    fun recognizeObjectInImage(file: File) : Observable<Array<String>> {
        return getNamesForObjectInImageUseCase.inImageFrom(file).performAndObserve(Schedulers.io())
    }

    fun storeReadyImageObject(imageObject: ImageObject) {

    }
}
