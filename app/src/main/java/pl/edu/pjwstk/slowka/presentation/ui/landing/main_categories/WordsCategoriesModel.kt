package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ViewAllCategoriesUseCase
import rx.Observable
import rx.schedulers.Schedulers

class WordsCategoriesModel (private val viewAllCategoriesUseCase: ViewAllCategoriesUseCase) {

    fun getAllCategories() : Observable<Cursor> {
        return viewAllCategoriesUseCase.performAndObserve(Schedulers.io())
    }
}
