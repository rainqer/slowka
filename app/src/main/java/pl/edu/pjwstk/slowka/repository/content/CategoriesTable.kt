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
        database.insert(NAME, null, Category("Home", Icon.HOME).toContentValues())
        database.insert(NAME, null, Category("School", Icon.SCHOOL).toContentValues())
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
