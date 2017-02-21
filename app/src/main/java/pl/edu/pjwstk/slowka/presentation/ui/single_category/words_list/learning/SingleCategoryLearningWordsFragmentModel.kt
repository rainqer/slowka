package pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.learning

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedLearningCategoryImagesObjectsUseCase
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.SingleCategoryWordsListFragmentModel
import rx.Observable
import rx.schedulers.Schedulers

class SingleCategoryLearningWordsFragmentModel
    constructor(val viewAcceptedLearningCategoryImagesObjectsUseCase: ViewAcceptedLearningCategoryImagesObjectsUseCase)
    : SingleCategoryWordsListFragmentModel() {

    override fun getImages(categoryName: String): Observable<Cursor> {
        return viewAcceptedLearningCategoryImagesObjectsUseCase
                .category(categoryName)
                .performAndObserve(Schedulers.io())
    }
}
