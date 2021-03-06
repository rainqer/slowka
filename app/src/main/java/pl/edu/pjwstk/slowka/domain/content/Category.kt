package pl.edu.pjwstk.slowka.domain.content

import android.content.ContentValues
import android.database.Cursor
import android.support.annotation.StringRes
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.repository.content.CategoriesTable
import java.io.Serializable

class Category: Serializable {

    @StringRes val name: Int
    val id: Int
    private val icon: Icon
    val iconRes : Int
        get() = icon.drawableRes

    constructor(cursor: Cursor) {
        name = cursor.getInt(cursor.getColumnIndexOrThrow(CategoriesTable.COLUMN_NAME))
        id = cursor.getInt(cursor.getColumnIndexOrThrow(CategoriesTable.COLUMN_ID))
        icon = Icon.fromOrdinal(cursor.getInt(cursor.getColumnIndexOrThrow(CategoriesTable.COLUMN_ICON)))
    }

    constructor(@StringRes name: Int, icon: Icon) {
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

    val color: Int
        get() = when (this.name) {
            HOME -> R.color.color1
            HOBBY -> R.color.color2
            FOOD -> R.color.color3
            PEOPLE -> R.color.color4
            ACTIVITIES -> R.color.color5
            OTHER -> R.color.color6
            else -> R.color.color6
    }

    companion object {
        val CATEGORY_NOT_FROM_DATABASE_ID = -1
        val HOME = R.string.category_home
        val HOBBY = R.string.category_hobby
        val FOOD = R.string.category_food
        val PEOPLE = R.string.category_people
        val ACTIVITIES = R.string.category_activities
        val OTHER = R.string.category_other
    }
}
