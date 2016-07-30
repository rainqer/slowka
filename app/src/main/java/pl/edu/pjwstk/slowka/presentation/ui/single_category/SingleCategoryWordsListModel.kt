package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedCategoryImageObjectsUseCase
import rx.Observable
import rx.schedulers.Schedulers

class SingleCategoryWordsListModel
    constructor(val viewAcceptedCategoryImageObjectsUseCase: ViewAcceptedCategoryImageObjectsUseCase) {

    fun getReadyImages(categoryName: String): Observable<Cursor> {
        return viewAcceptedCategoryImageObjectsUseCase.category(categoryName).performAndObserve(Schedulers.io())
    }
}
