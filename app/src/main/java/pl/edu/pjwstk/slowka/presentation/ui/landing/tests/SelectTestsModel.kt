package pl.edu.pjwstk.slowka.presentation.ui.landing.tests

import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.domain.content.CategoryWithWords
import pl.edu.pjwstk.slowka.domain.content.CountAllImageObjectsWithCategoriesUseCase
import pl.edu.pjwstk.slowka.domain.test.UserStartsTestForCategoryUseCase
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

class SelectTestsModel(private val countAllImageObjectsWithCategoriesUseCase: CountAllImageObjectsWithCategoriesUseCase,
                       private val userStartsTestForCategoryUseCase: UserStartsTestForCategoryUseCase) {

    fun getAllWords() : Observable<List<CategoryWithWords>> {
        return countAllImageObjectsWithCategoriesUseCase.perform()
    }

    fun startTestForCategory(category: Category): Observable<Unit> {
        return userStartsTestForCategoryUseCase.category(category).performAndObserve(AndroidSchedulers.mainThread())
    }
}
