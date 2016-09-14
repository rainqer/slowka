package pl.edu.pjwstk.slowka.presentation.ui.landing.tests

import pl.edu.pjwstk.slowka.domain.content.CategoryWithWords
import pl.edu.pjwstk.slowka.domain.content.CountImageObjectsWithCategoriesUseCase
import rx.Observable

class SelectTestsModel(private val countImageObjectsWithCategoriesUseCase: CountImageObjectsWithCategoriesUseCase) {

    fun getAllWords() : Observable<List<CategoryWithWords>> {
        return countImageObjectsWithCategoriesUseCase.perform()
    }
}
