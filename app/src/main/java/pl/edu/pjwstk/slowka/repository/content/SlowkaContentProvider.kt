package pl.edu.pjwstk.slowka.repository.content

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.domain.content.ImageObject

class SlowkaContentProvider : ContentProvider() {

    lateinit var sqlLiteHelper: SqlLiteHelper

    init {
        matcher.addURI(AUTHORITY, ImageObjectsTable.PATH, imageObjectsProviderCode)
        matcher.addURI(AUTHORITY, CategoriesTable.PATH, categoriesProviderCode)
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
            imageObjectsProviderCode -> ImageObjectsTable.NAME
            categoriesProviderCode -> CategoriesTable.NAME
            else -> ImageObjectsTable.NAME
        }
    }

    override fun getType(uri: Uri): String {
        return when (getProviderCode(uri)) {
            imageObjectsProviderCode -> ImageObject::class.java.toString()
            categoriesProviderCode -> Category::class.java.toString()
            else -> ImageObject::class.java.toString()
        }
    }

    private fun getProviderCode(uri: Uri) : Int {
        return matcher.match(uri)
    }

    companion object {
        val ERROR = -1
        private val AUTHORITY = "pl.edu.pjwstk.slowka.repository.provider"
        private val CONTENT = Uri.parse("content://" + AUTHORITY)
        private val matcher = UriMatcher(UriMatcher.NO_MATCH);
        private val imageObjectsProviderCode = 1;
        private val categoriesProviderCode = 2;

        val IMAGE_OBJECT_URI = Uri.withAppendedPath(CONTENT, ImageObjectsTable.PATH);
        val CATEGORY_URI = Uri.withAppendedPath(CONTENT, CategoriesTable.PATH)
    }
}
