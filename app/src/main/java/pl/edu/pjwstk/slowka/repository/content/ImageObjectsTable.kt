package pl.edu.pjwstk.slowka.repository.content

import android.database.sqlite.SQLiteDatabase

class ImageObjectsTable : SqlTable {

    override fun create(database: SQLiteDatabase) {
        val sqlCommand = StringBuilder("CREATE TABLE ").append(NAME).append(" (")
                .append(COLUMN_ID).append(" ").append("INTEGER").append(" PRIMARY KEY AUTOINCREMENT").append(", ")
                .append(COLUMN_NAME).append(" ").append("TEXT").append(", ")
                .append(COLUMN_IMAGE_URL).append(" ").append("TEXT")
                .append(COLUMN_CATEGORY).append(" ").append("TEXT")
                .append(")");
        database.execSQL(sqlCommand.toString())
    }

    companion object {
        val NAME = "ImageObjects"
        val COLUMN_ID = "_id"
        val COLUMN_NAME = "objectName"
        val COLUMN_IMAGE_URL = "imageUrl"
        val COLUMN_CATEGORY = "category"
        val COLUMNS = arrayOf("_id", "objectName", "imageUrl", "category")

        val PATH = "imageObjects"
    }
}
