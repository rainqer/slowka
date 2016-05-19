package pl.edu.pjwstk.slowka.repository.content

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.content.ImageObjectRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AndroidImageObjectRepository : ImageObjectRepository {

    val contentResolver: ContentResolver
    val IMAGE_OBJECT_PROVIDER_URI = SlowkaContentProvider.IMAGE_OBJECT_URI
    val SINGLE_ROW_AFFECTED = 1

    @Inject
    constructor(context: Context) {
        this.contentResolver = context.contentResolver
    }

    override fun getAll(): Cursor {
        return contentResolver.query(IMAGE_OBJECT_PROVIDER_URI, ImageObjectsTable.COLUMNS, null, arrayOf(), null)
    }

    override fun edit(id: String, imageObject: ImageObject): Boolean {
        return contentResolver.update(
                IMAGE_OBJECT_PROVIDER_URI,
                imageObject.toContentValues(),
                whereIdEquals(id),
                null
        ) == SINGLE_ROW_AFFECTED
    }

    override fun insert(imageObject: ImageObject): Boolean {
        return contentResolver.insert(
                IMAGE_OBJECT_PROVIDER_URI,
                imageObject.toContentValues()
        ) != null
    }

    override fun delete(id: String): Boolean {
        return contentResolver.delete(
                IMAGE_OBJECT_PROVIDER_URI,
                whereIdEquals(id),
                null
        ) == SINGLE_ROW_AFFECTED
    }

    private fun whereIdEquals(id: String) = ImageObjectsTable.COLUMN_ID + "=" + id
}
