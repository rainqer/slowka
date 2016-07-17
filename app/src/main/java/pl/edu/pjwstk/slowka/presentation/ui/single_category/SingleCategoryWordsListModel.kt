package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ViewAllImageObjectsUseCase
import rx.Observable
import rx.schedulers.Schedulers

class SingleCategoryWordsListModel
    constructor(val viewAllImageObjectsUseCase: ViewAllImageObjectsUseCase) {

    fun getImages(): Observable<Cursor> {
        return viewAllImageObjectsUseCase.performAndObserve(Schedulers.io())
    }
}
