package pl.edu.pjwstk.slowka.domain.content

import android.content.ContentValues
import android.database.Cursor
import pl.edu.pjwstk.slowka.repository.content.ImageObjectsTable
import java.io.File

class ImageObject {

    val imageFile: File
    val annotation: String
    val categoryName: String
    val objectId: Int?

    constructor(cursor: Cursor) {
        val imageFilePath = cursor.getString(cursor.getColumnIndexOrThrow(ImageObjectsTable.COLUMN_IMAGE_URL))
        val annotation = cursor.getString(cursor.getColumnIndexOrThrow(ImageObjectsTable.COLUMN_NAME))
        val categoryName = cursor.getString(cursor.getColumnIndexOrThrow(ImageObjectsTable.COLUMN_CATEGORY))
        val objectId = cursor.getInt(cursor.getColumnIndexOrThrow(ImageObjectsTable.COLUMN_ID))
        this.imageFile = File(imageFilePath)
        this.annotation = annotation
        this.categoryName = categoryName
        this.objectId = objectId
    }

    constructor(imageFile: File, annotation: String, categoryName: String) {
        this.imageFile = imageFile
        this.annotation = annotation
        this.categoryName = categoryName
        this.objectId = null
    }

    fun toContentValues(): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(ImageObjectsTable.COLUMN_NAME, annotation)
        contentValues.put(ImageObjectsTable.COLUMN_IMAGE_URL, imageFile.absolutePath)
        contentValues.put(ImageObjectsTable.COLUMN_CATEGORY, categoryName)
        return contentValues
    }
}
