package pl.edu.pjwstk.slowka.presentation.ui.landing.tests

import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.domain.content.CategoryWithWords
import pl.edu.pjwstk.slowka.domain.content.CountImageObjectsWithCategoriesUseCase
import pl.edu.pjwstk.slowka.domain.test.UserStartsTestForCategoryUseCase
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

class SelectTestsModel(private val countImageObjectsWithCategoriesUseCase: CountImageObjectsWithCategoriesUseCase,
                       private val userStartsTestForCategoryUseCase: UserStartsTestForCategoryUseCase) {

    fun getAllWords() : Observable<List<CategoryWithWords>> {
        return countImageObjectsWithCategoriesUseCase.perform()
    }

    fun startTestForCategory(category: Category): Observable<Unit> {
        return userStartsTestForCategoryUseCase.category(category).performAndObserve(AndroidSchedulers.mainThread())
    }
}
