package pl.edu.pjwstk.slowka.repository.content

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import pl.edu.pjwstk.slowka.domain.content.ImageObject

class ImageObjectsContentProvider : ContentProvider() {

    val TABLE_NAME = ImageObjectsTable.NAME
    lateinit var sqlLiteHelper: SqlLiteHelper

    override fun onCreate(): Boolean {
        sqlLiteHelper = SqlLiteHelper(context)
        return true
    }

    override fun insert(uri: Uri?,
                        values: ContentValues?) : Uri? {

        sqlLiteHelper.writableDatabase?.insert(TABLE_NAME, null, values)
        return uri
    }

    override fun query(uri: Uri?,
                       columns: Array<out String>?,
                       whereCluase: String?,
                       whereArgs: Array<out String>?,
                       sortOrder: String?) : Cursor? {

        return sqlLiteHelper.readableDatabase?.query(TABLE_NAME, columns, whereCluase, whereArgs, null, null, sortOrder)
    }

    override fun update(uri: Uri?,
                        values: ContentValues?,
                        whereClause: String?,
                        whereArgs: Array<out String>?) : Int {

        return sqlLiteHelper.writableDatabase?.update(TABLE_NAME, values, whereClause, whereArgs) ?: ERROR
    }

    override fun delete(uri: Uri?,
                        selection: String?,
                        selectionArgs: Array<out String>?): Int {

        return sqlLiteHelper.writableDatabase?.delete(TABLE_NAME, selection, selectionArgs) ?: ERROR
    }

    override fun getType(uri: Uri?): String {
        return ImageObject::class.java.toString()
    }

    companion object {
        val ERROR = -1
        val URI = Uri.parse("content://pl.edu.pjwstk.slowka.repository.provider/imageobjects")
    }
}
