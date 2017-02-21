package pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.known

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedCategoryImageObjectsUseCase
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.SingleCategoryWordsListFragmentModel
import rx.Observable
import rx.schedulers.Schedulers

class SingleCategoryKnownWordsFragmentModel
    constructor(val viewAcceptedCategoryImageObjectsUseCase: ViewAcceptedCategoryImageObjectsUseCase)
    : SingleCategoryWordsListFragmentModel() {

    override fun getImages(categoryName: String): Observable<Cursor> {
        return viewAcceptedCategoryImageObjectsUseCase.category(categoryName).performAndObserve(Schedulers.io())
    }
}
