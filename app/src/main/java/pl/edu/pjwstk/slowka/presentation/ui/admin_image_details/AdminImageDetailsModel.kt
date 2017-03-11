package pl.edu.pjwstk.slowka.presentation.ui.admin_image_details

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.*
import rx.Observable
import rx.schedulers.Schedulers

class AdminImageDetailsModel constructor(
        private val updateImageObjectUseCase: UpdateImageObjectUseCase,
        private val getCategoriesUseCase: ViewAllCategoriesUseCase,
        private val getImageObjectUseCase: GetImageObjectUseCase,
        private val restoreImageObjectToUnknownUseCase: RestoreImageObjectToUnknownUseCase
    ) {

    fun getAllCategories() :Observable<Cursor> {
        return getCategoriesUseCase.performAndObserve(Schedulers.io())
    }

    fun getImageObject(imageObjectId: Int) :Observable<ImageObject> {
        return getImageObjectUseCase.id(imageObjectId).performAndObserve(Schedulers.io())
    }

    fun updateImageObject(imageObjectId: Int, imageAnnotation: String, selectedCategory: String): Observable<Boolean> {
        return getImageObjectUseCase.id(imageObjectId).performAndObserve(Schedulers.io())
        .map { imageObject -> ImageObject(imageObject.imageFile, imageAnnotation, selectedCategory) }
        .map { imageObject -> imageObject.accepted() }
        .map { imageObject ->
            updateImageObjectUseCase
                    .id(imageObjectId)
                    .imageObject(imageObject)
                    .perform()
        }
    }

    fun restoreImageToLearning(imageObjectId: Int) {
        restoreImageObjectToUnknownUseCase.imageObjectId(imageObjectId).perform()
    }
}
