package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import pl.edu.pjwstk.slowka.domain.content.CategoryWithWords
import pl.edu.pjwstk.slowka.domain.content.CountImageObjectsWithCategoriesUseCase
import rx.Observable

class WordsCategoriesModel (private val countImageObjectsWithCategoriesUseCase: CountImageObjectsWithCategoriesUseCase) {

    fun getAllWords(): Observable<List<CategoryWithWords>> {
        return countImageObjectsWithCategoriesUseCase.perform()
    }
}
