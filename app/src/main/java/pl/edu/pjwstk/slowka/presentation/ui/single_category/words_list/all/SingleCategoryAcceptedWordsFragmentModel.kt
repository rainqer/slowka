package pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.all

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedCategoryImagesObjectsUseCase
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.SingleCategoryWordsListFragmentModel
import rx.Observable
import rx.schedulers.Schedulers

class SingleCategoryAcceptedWordsFragmentModel
    constructor(val viewAcceptedCategoryImagesObjectsUseCase: ViewAcceptedCategoryImagesObjectsUseCase)
    : SingleCategoryWordsListFragmentModel() {

    override fun getImages(categoryName: Int): Observable<Cursor> {
        return viewAcceptedCategoryImagesObjectsUseCase
                .category(categoryName)
                .performAndObserve(Schedulers.io())
    }
}
