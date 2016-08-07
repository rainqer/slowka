package pl.edu.pjwstk.slowka.domain.content

import android.database.Cursor

class CategoryWithWords {

    val category: Category
    var numberOfKnownWords = 0
    var numberOfNotKnownWords = 0

    constructor(cursor: Cursor) {
        category = Category(cursor)
    }

    fun incKnown() {
        ++numberOfKnownWords
    }

    fun incNotKnown() {
        ++ numberOfNotKnownWords
    }
}
