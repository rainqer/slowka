package pl.edu.pjwstk.slowka.domain.content

import android.database.Cursor

interface CategoryRepository {

    fun getAll(): Cursor
    fun edit(id: String, category: Category) : Boolean
    fun insert(category: Category) : Boolean
    fun delete(id: String) : Boolean
}
