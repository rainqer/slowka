package pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.known

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedKnownCategoryImagesObjectsUseCase
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.SingleCategoryWordsListFragmentModel
import rx.Observable
import rx.schedulers.Schedulers

class SingleCategoryKnownWordsFragmentModel
    constructor(val viewAcceptedKnownCategoryImagesObjectsUseCase: ViewAcceptedKnownCategoryImagesObjectsUseCase)
    : SingleCategoryWordsListFragmentModel() {

    override fun getImages(categoryName: Int): Observable<Cursor> {
        return viewAcceptedKnownCategoryImagesObjectsUseCase
                .category(categoryName)
                .performAndObserve(Schedulers.io())
    }
}
