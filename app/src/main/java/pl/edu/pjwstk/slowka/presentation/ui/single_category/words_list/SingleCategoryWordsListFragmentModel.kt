package pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list

import android.database.Cursor
import rx.Observable

abstract class SingleCategoryWordsListFragmentModel () {

    abstract fun getImages(categoryName: Int): Observable<Cursor>
}
