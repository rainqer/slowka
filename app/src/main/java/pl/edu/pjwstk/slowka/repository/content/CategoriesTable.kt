package pl.edu.pjwstk.slowka.repository.content

import android.database.sqlite.SQLiteDatabase
import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.domain.content.Icon

class CategoriesTable : SqlTable {

    override fun create(database: SQLiteDatabase) {
        val sqlCommand = StringBuilder("CREATE TABLE ").append(NAME).append(" (")
                .append(COLUMN_ID).append(" ").append("INTEGER").append(" PRIMARY KEY AUTOINCREMENT").append(", ")
                .append(COLUMN_NAME).append(" ").append("TEXT").append(", ")
                .append(COLUMN_ICON).append(" ").append("INTEGER")
                .append(")");
        database.execSQL(sqlCommand.toString())
        insertPrimaryData(database)
    }

    private fun insertPrimaryData(database: SQLiteDatabase) {
        database.insert(NAME, null, Category(Category.HOME, Icon.HOME).toContentValues())
        database.insert(NAME, null, Category(Category.HOBBY, Icon.HOBBY).toContentValues())
        database.insert(NAME, null, Category(Category.FOOD, Icon.FOOD).toContentValues())
        database.insert(NAME, null, Category(Category.PEOPLE, Icon.PEOPLE).toContentValues())
        database.insert(NAME, null, Category(Category.ACTIVITIES, Icon.ACTIVITIES).toContentValues())
        database.insert(NAME, null, Category(Category.OTHER, Icon.OTHER).toContentValues())
    }

    companion object {
        val NAME = "Categories"
        val COLUMN_ID = "_id"
        val COLUMN_NAME = "categoryName"
        val COLUMN_ICON = "categoryIcon"

        val COLUMNS = arrayOf("_id", "categoryName", "categoryIcon")
        val PATH = "categories"

    }
}
