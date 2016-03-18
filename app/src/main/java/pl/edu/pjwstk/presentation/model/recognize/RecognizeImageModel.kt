package pl.edu.pjwstk.presentation.model.recognize

import pl.edu.pjwstk.domain.information.GetNamesForObjectInImageUseCase
import pl.edu.pjwstk.presentation.dagger.recognize.RecognizeImageActivityScope
import rx.Observable
import rx.schedulers.Schedulers
import javax.inject.Inject

@RecognizeImageActivityScope
class RecognizeImageModel @Inject constructor(
        private val getNamesForObjectInImageUseCase: GetNamesForObjectInImageUseCase) {

    fun recognizeObjectInImage() : Observable<Array<String>> {
        return getNamesForObjectInImageUseCase.performAndObserve(Schedulers.io())
    }
}
