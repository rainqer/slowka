package pl.edu.pjwstk.slowka.repository.content

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.presentation.dagger.Components

class SlowkaContentProvider : ContentProvider() {

    lateinit var sqlLiteHelper: SqlLiteHelper

    init {
        matcher.addURI(authority, ImageObjectsTable.PATH, imageObjectsProviderCode)
        matcher.addURI(authority, CategoriesTable.PATH, categoriesProviderCode)
    }


    override fun onCreate(): Boolean {
        sqlLiteHelper = SqlLiteHelper(context)
        return true
    }

    override fun insert(uri: Uri, values: ContentValues?) : Uri {

        sqlLiteHelper.writableDatabase?.insert(getTableName(uri), null, values)
        return uri
    }

    override fun query(uri: Uri,
                       columns: Array<out String>?,
                       whereCluase: String?,
                       whereArgs: Array<out String>?,
                       sortOrder: String?) : Cursor? {

        return sqlLiteHelper.readableDatabase?.query(getTableName(uri), columns, whereCluase, whereArgs, null, null, sortOrder)
    }

    override fun update(uri: Uri,
                        values: ContentValues?,
                        whereClause: String?,
                        whereArgs: Array<out String>?) : Int {

        return sqlLiteHelper.writableDatabase?.update(getTableName(uri), values, whereClause, whereArgs) ?: ERROR
    }

    override fun delete(uri: Uri,
                        selection: String?,
                        selectionArgs: Array<out String>?): Int {

        return sqlLiteHelper.writableDatabase?.delete(getTableName(uri), selection, selectionArgs) ?: ERROR
    }

    private fun getTableName(uri: Uri) : String {
        return when (getProviderCode(uri)) {
            imageObjectsProviderCode -> ImageObjectsTable.NAME;
            else -> ImageObjectsTable.NAME
        }
    }

    override fun getType(uri: Uri): String {
        return when (getProviderCode(uri)) {
            imageObjectsProviderCode -> ImageObject::class.java.toString()
            else -> ImageObject::class.java.toString()
        }
    }

    private fun getProviderCode(uri: Uri) : Int {
        return matcher.match(uri)
    }

    companion object {
        val ERROR = -1
        val authority = "content://pl.edu.pjwstk.slowka.repository.provider"
        val IMAGE_OBJECT_URI = Uri.parse("$authority/${ImageObjectsTable.PATH}")
        val CATEGORY_URI = Uri.parse("$authority/${CategoriesTable.PATH}")

        val matcher = UriMatcher(UriMatcher.NO_MATCH);
        val imageObjectsProviderCode = 1;
        val categoriesProviderCode = 2;
    }
}
