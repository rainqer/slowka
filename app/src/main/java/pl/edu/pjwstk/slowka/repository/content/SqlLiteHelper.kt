package pl.edu.pjwstk.slowka.repository.content

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqlLiteHelper(context: Context)
    : SQLiteOpenHelper(context, SqlLiteHelper.DATABASE_NAME, null, SqlLiteHelper.DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        ImageObjectsTable().create(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    companion object {

        val DATABASE_NAME = "slowka.db"
        private val DATABASE_VERSION = 1
    }
}
