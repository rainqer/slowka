package pl.edu.pjwstk.slowka.domain.content

import android.content.ContentValues
import android.database.Cursor
import pl.edu.pjwstk.slowka.repository.content.CategoriesTable

class Category {

    val name: String
    val id: Int
    private val icon: Icon
    val iconRes : Int
        get() = icon.drawableRes

    constructor(cursor: Cursor) {
        name = cursor.getString(cursor.getColumnIndexOrThrow(CategoriesTable.COLUMN_NAME))
        id = cursor.getInt(cursor.getColumnIndexOrThrow(CategoriesTable.COLUMN_ID))
        icon = Icon.fromOrdinal(cursor.getInt(cursor.getColumnIndexOrThrow(CategoriesTable.COLUMN_ICON)))
    }

    constructor(name: String, icon: Icon) {
        this.name = name
        this.icon = icon
        this.id = CATEGORY_NOT_FROM_DATABASE_ID
    }

    fun toContentValues(): ContentValues? {
        val contentValues = ContentValues()
        contentValues.put(CategoriesTable.COLUMN_NAME, name)
        contentValues.put(CategoriesTable.COLUMN_ICON, icon.ordinal)
        return contentValues
    }

    companion object {
        val CATEGORY_NOT_FROM_DATABASE_ID = -1
        val HOME = "home"
        val SPORT = "Sport"
        val WEATHER = "Weather"
        val PEOPLE = "People"
        val HOLIDAY = "Holiday"
        val GROCERY = "Grocery"
    }
}
