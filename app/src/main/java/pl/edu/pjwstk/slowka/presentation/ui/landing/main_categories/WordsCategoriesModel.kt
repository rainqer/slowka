package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import pl.edu.pjwstk.slowka.domain.content.CategoryWithWords
import pl.edu.pjwstk.slowka.domain.content.CountAllImageObjectsWithCategoriesUseCase
import rx.Observable

class WordsCategoriesModel (private val countAllImageObjectsWithCategoriesUseCase: CountAllImageObjectsWithCategoriesUseCase) {

    fun getAllWords(): Observable<List<CategoryWithWords>> {
        return countAllImageObjectsWithCategoriesUseCase.perform()
    }
}
