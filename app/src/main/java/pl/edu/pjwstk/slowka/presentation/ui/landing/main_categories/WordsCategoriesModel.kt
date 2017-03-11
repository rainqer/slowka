package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import pl.edu.pjwstk.slowka.domain.content.CategoryWithWords
import pl.edu.pjwstk.slowka.domain.content.CountAllImageObjectsWithCategoriesUseCase
import pl.edu.pjwstk.slowka.domain.content.GetRecentlyAddedWordUseCase
import rx.Observable

class WordsCategoriesModel (private val countAllImageObjectsWithCategoriesUseCase: CountAllImageObjectsWithCategoriesUseCase,
                            private val getRecentlyAddedWordUseCase: GetRecentlyAddedWordUseCase) {

    fun getAllWords(): Observable<List<CategoryWithWords>> {
        return countAllImageObjectsWithCategoriesUseCase.perform()
    }

    fun getRecentWord(): String? {
        return getRecentlyAddedWordUseCase.perform()
    }
}
