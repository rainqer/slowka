package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_learn

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ViewAllImageObjectsUseCase
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.WordsListFragmentModel
import rx.Observable
import rx.schedulers.Schedulers
import javax.inject.Inject

class ILearnWordsListFragmentModel
    @Inject constructor(val viewAllImageObjectsUseCase: ViewAllImageObjectsUseCase)
    : WordsListFragmentModel() {

    override fun getImages(): Observable<Cursor> {
        return viewAllImageObjectsUseCase.performAndObserve(Schedulers.io())
    }
}
