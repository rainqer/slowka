package pl.edu.pjwstk.slowka.domain.content

import android.content.ContentValues
import android.database.Cursor
import pl.edu.pjwstk.slowka.repository.content.CategoriesTable

class Category {

    val name: String
    private val icon: Icon
    val iconRes : Int
        get() = icon.drawableRes

    constructor(cursor: Cursor) {
        name = cursor.getString(cursor.getColumnIndexOrThrow(CategoriesTable.COLUMN_NAME))
        icon = Icon.fromOrdinal(cursor.getInt(cursor.getColumnIndexOrThrow(CategoriesTable.COLUMN_ICON)))
    }

    constructor(name: String, icon: Icon) {
        this.name = name
        this.icon = icon
    }

    fun toContentValues(): ContentValues? {
        val contentValues = ContentValues()
        contentValues.put(CategoriesTable.COLUMN_NAME, name)
        contentValues.put(CategoriesTable.COLUMN_ICON, icon.ordinal)
        return contentValues
    }
}
