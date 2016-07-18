package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ViewCategoryImageObjectsUseCase
import rx.Observable
import rx.schedulers.Schedulers

class SingleCategoryWordsListModel
    constructor(val viewCategoryImageObjectsUseCase: ViewCategoryImageObjectsUseCase) {

    fun getImages(categoryName: String): Observable<Cursor> {
        return viewCategoryImageObjectsUseCase.category(categoryName).performAndObserve(Schedulers.io())
    }
}
