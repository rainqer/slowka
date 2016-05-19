package pl.edu.pjwstk.slowka.repository.content

import android.database.sqlite.SQLiteDatabase

class CategoriesTable : SqlTable {

    override fun create(database: SQLiteDatabase) {
        var sqlCommand = StringBuilder("CREATE TABLE ").append(NAME).append(" (")
                .append(COLUMN_ID).append(" ").append("INTEGER").append(" PRIMARY KEY AUTOINCREMENT").append(", ")
                .append(COLUMN_NAME).append(" ").append("TEXT").append(", ")
                .append(")");
        database.execSQL(sqlCommand.toString())
    }

    companion object {
        val NAME = "Categories"
        val COLUMN_ID = "_id"
        val COLUMN_NAME = "categoryName"
        val COLUMNS = arrayOf("_id", "categoryName", "imageUrl")

        val PATH = "categories"
    }
}
