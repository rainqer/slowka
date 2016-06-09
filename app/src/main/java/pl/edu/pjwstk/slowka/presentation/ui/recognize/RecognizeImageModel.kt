package pl.edu.pjwstk.slowka.presentation.ui.recognize

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.*
import pl.edu.pjwstk.slowka.domain.information.GetNamesForObjectInImageUseCase
import rx.Observable
import rx.schedulers.Schedulers
import java.io.File

class RecognizeImageModel constructor(
        private val getNamesForObjectInImageUseCase: GetNamesForObjectInImageUseCase,
        private val storeImageObjectUseCase: StoreImageObjectUseCase,
        private val getCategoriesUseCase: ViewAllCategoriesUseCase,
        private val storeCategoryUseCase: StoreCategoryUseCase
    ) {

    fun recognizeObjectInImage(file: File) : Observable<Array<String>> {
        return getNamesForObjectInImageUseCase.inImageFrom(file).performAndObserve(Schedulers.io())
    }

    fun storeReadyImageObject(imageObject: ImageObject) : Observable<Boolean> {
        return storeImageObjectUseCase.image(imageObject).performAndObserve(Schedulers.io())
    }

    fun getAllCategories() :Observable<Cursor> {
        return getCategoriesUseCase.performAndObserve(Schedulers.io())
    }
}
