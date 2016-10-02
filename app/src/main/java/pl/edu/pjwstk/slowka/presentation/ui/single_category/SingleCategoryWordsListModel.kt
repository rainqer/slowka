package pl.edu.pjwstk.slowka.presentation.ui.single_category

import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedCategoryConvertedImageObjectsUseCase
import rx.Observable
import rx.schedulers.Schedulers

class SingleCategoryWordsListModel
    constructor(val viewAcceptedCategoryConvertedImageObjectsUseCase: ViewAcceptedCategoryConvertedImageObjectsUseCase) {

    fun getReadyImages(categoryName: String): Observable<List<ImageObject>> {
        return viewAcceptedCategoryConvertedImageObjectsUseCase.category(categoryName).performAndObserve(Schedulers.io())
    }
}
