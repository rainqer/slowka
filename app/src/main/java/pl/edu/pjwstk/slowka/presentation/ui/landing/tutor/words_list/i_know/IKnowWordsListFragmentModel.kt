package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_know

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ViewKnownImageObjectsUseCase
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.WordsListFragmentModel
import rx.Observable
import rx.schedulers.Schedulers

class IKnowWordsListFragmentModel
    constructor(val viewKnownImageObjectsUseCase: ViewKnownImageObjectsUseCase)
    : WordsListFragmentModel() {

    override fun getImages(): Observable<Cursor> {
        return viewKnownImageObjectsUseCase.performAndObserve(Schedulers.io())
    }
}
