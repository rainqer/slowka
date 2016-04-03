package pl.edu.pjwstk.slowka.domain.content

import android.content.ContentValues
import android.database.Cursor
import pl.edu.pjwstk.slowka.repository.content.ImageObjectsTable
import java.io.File

class ImageObject {

    val imageFile: File
    val annotation: String

    constructor(cursor: Cursor) {
        val imageFilePath = cursor.getString(cursor.getColumnIndexOrThrow(ImageObjectsTable.COLUMN_IMAGE_URL))
        val annotation = cursor.getString(cursor.getColumnIndexOrThrow(ImageObjectsTable.COLUMN_NAME))
        this.imageFile = File(imageFilePath)
        this.annotation = annotation
    }

    constructor(imageFile: File, annotation: String) {
        this.imageFile = imageFile
        this.annotation = annotation
    }

    fun toContentValues(): ContentValues? {
        val contentValues = ContentValues()
        contentValues.put(ImageObjectsTable.COLUMN_NAME, annotation)
        contentValues.put(ImageObjectsTable.COLUMN_IMAGE_URL, imageFile.absolutePath)
        return contentValues
    }
}
