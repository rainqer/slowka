package pl.edu.pjwstk.slowka.repository.content

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.domain.content.CategoryRepository
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.content.ImageObjectRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalCategoryRepository : CategoryRepository {

    val contentResolver: ContentResolver
    val CATEGORY_PROVIDER_URI = SlowkaContentProvider.CATEGORY_URI
    val SINGLE_ROW_AFFECTED = 1

    @Inject
    constructor(context: Context) {
        this.contentResolver = context.contentResolver
    }

    override fun getAll(): Cursor {
        return contentResolver.query(CATEGORY_PROVIDER_URI, CategoriesTable.COLUMNS, null, arrayOf(), null)
    }

    override fun edit(id: String, category: Category): Boolean {
        return contentResolver.update(
                CATEGORY_PROVIDER_URI,
                category.toContentValues(),
                whereIdEquals(id),
                null
        ) == SINGLE_ROW_AFFECTED
    }

    override fun insert(category: Category): Boolean {
        return contentResolver.insert(
                CATEGORY_PROVIDER_URI,
                category.toContentValues()
        ) != null
    }

    override fun delete(id: String): Boolean {
        return contentResolver.delete(
                CATEGORY_PROVIDER_URI,
                whereIdEquals(id),
                null
        ) == SINGLE_ROW_AFFECTED
    }

    private fun whereIdEquals(id: String) = ImageObjectsTable.COLUMN_ID + "=" + id
}
