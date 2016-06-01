package pl.edu.pjwstk.slowka.domain.content

import android.content.ContentValues
import android.database.Cursor
import pl.edu.pjwstk.slowka.repository.content.CategoriesTable
import pl.edu.pjwstk.slowka.repository.content.ImageObjectsTable

class Category {

    val name: String

    constructor(cursor: Cursor) {
        val name = cursor.getString(cursor.getColumnIndexOrThrow(CategoriesTable.COLUMN_NAME))
        this.name = name
    }

    constructor(name: String) {
        this.name = name
    }

    fun toContentValues(): ContentValues? {
        val contentValues = ContentValues()
        contentValues.put(ImageObjectsTable.COLUMN_NAME, name)
        return contentValues
    }
}
