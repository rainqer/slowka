package pl.edu.pjwstk.slowka.repository.content

import android.content.ContentResolver
import android.content.Context
import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.content.ImageObjectRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalImageObjectRepository : ImageObjectRepository {

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

    override fun getAllPending(): Cursor {
        return contentResolver.query(
                IMAGE_OBJECT_PROVIDER_URI,
                ImageObjectsTable.COLUMNS,
                "${ImageObjectsTable.COLUMN_ACCEPTED}='0'",
                arrayOf(),
                null
        )
    }

    override fun getAllKnown(): Cursor {
        return contentResolver.query(
                IMAGE_OBJECT_PROVIDER_URI,
                ImageObjectsTable.COLUMNS,
                "${ImageObjectsTable.COLUMN_KNOWN}='1'",
                arrayOf(),
                null
        )
    }

    override fun getAllAcceptedUnknown(): Cursor {
        return contentResolver.query(
                IMAGE_OBJECT_PROVIDER_URI,
                ImageObjectsTable.COLUMNS,
                "${ImageObjectsTable.COLUMN_ACCEPTED}='1' AND ${ImageObjectsTable.COLUMN_KNOWN}='0'",
                arrayOf(),
                null
        )
    }

    override fun get(objectId: Int): Cursor {
        return contentResolver.query(
                IMAGE_OBJECT_PROVIDER_URI,
                ImageObjectsTable.COLUMNS,
                "${ImageObjectsTable.COLUMN_ID}='$objectId'",
                arrayOf(),
                null
        )
    }

    override fun getAcceptedImagesInCategory(categoryName: String): Cursor {
        return contentResolver.query(
                IMAGE_OBJECT_PROVIDER_URI,
                ImageObjectsTable.COLUMNS,
                "${ImageObjectsTable.COLUMN_CATEGORY}='$categoryName' AND ${ImageObjectsTable.COLUMN_ACCEPTED}='1'",
                arrayOf(),
                null
        )
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

    override fun markAsKnown(id: Int): Boolean {
        val cursor = get(id)
        if (cursor.moveToFirst()) {
            val imageObjectToBeMarkedAsKnown = ImageObject(cursor)
            cursor.close()
            return markObjectAsKnown(id, imageObjectToBeMarkedAsKnown) == SINGLE_ROW_AFFECTED
        }
        cursor.close()
        return false
    }

    private fun LocalImageObjectRepository.markObjectAsKnown(id: Int, imageObjectToBeMarkedAsKnown: ImageObject): Int {
        return contentResolver.update(
                IMAGE_OBJECT_PROVIDER_URI,
                imageObjectToBeMarkedAsKnown.known().toContentValues(),
                whereIdEquals(id),
                null
        )
    }

    private fun whereIdEquals(id: String) = ImageObjectsTable.COLUMN_ID + "=$id"
    private fun whereIdEquals(id: Int) = ImageObjectsTable.COLUMN_ID + "=$id"
}
