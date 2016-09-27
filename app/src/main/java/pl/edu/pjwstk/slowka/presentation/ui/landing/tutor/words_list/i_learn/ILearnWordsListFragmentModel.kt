package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_learn

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedUnknownImageObjectsUseCase
import pl.edu.pjwstk.slowka.domain.content.ViewAllImageObjectsUseCase
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.WordsListFragmentModel
import rx.Observable
import rx.schedulers.Schedulers

class ILearnWordsListFragmentModel
    constructor(val viewAcceptedUnknownImageObjectsUseCase: ViewAcceptedUnknownImageObjectsUseCase)
    : WordsListFragmentModel() {

    override fun getImages(): Observable<Cursor> {
        return viewAcceptedUnknownImageObjectsUseCase.performAndObserve(Schedulers.io())
    }
}
