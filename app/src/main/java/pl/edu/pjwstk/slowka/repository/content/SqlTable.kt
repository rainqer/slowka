package pl.edu.pjwstk.slowka.repository.content

import android.database.sqlite.SQLiteDatabase

interface SqlTable {
    fun create(database: SQLiteDatabase)
}
