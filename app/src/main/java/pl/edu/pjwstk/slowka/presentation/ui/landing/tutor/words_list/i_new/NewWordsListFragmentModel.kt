package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_new

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ViewAllPendingImageObjectsUseCase
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.WordsListFragmentModel
import rx.Observable
import rx.schedulers.Schedulers

class NewWordsListFragmentModel
    constructor(val viewAllPendingImageObjectsUseCase: ViewAllPendingImageObjectsUseCase)
    : WordsListFragmentModel() {

    override fun getImages(): Observable<Cursor> {
        return viewAllPendingImageObjectsUseCase.performAndObserve(Schedulers.io())
    }
}
