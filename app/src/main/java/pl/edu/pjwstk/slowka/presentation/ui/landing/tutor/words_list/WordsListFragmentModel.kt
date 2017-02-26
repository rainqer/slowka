package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list

import android.database.Cursor
import rx.Observable

abstract class WordsListFragmentModel () {
    abstract fun getImages(): Observable<Cursor>
}
