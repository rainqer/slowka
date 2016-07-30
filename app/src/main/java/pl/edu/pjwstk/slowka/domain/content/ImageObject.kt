package pl.edu.pjwstk.slowka.domain.content

import android.content.ContentValues
import android.database.Cursor
import pl.edu.pjwstk.slowka.repository.content.ImageObjectsTable
import java.io.File

class ImageObject {

    val objectId: Int?
    val imageFile: File
    val annotation: String
    val categoryName: String
    val accepted: Boolean

    constructor(cursor: Cursor) {
        val objectId = cursor.getInt(cursor.getColumnIndexOrThrow(ImageObjectsTable.COLUMN_ID))
        val imageFilePath = cursor.getString(cursor.getColumnIndexOrThrow(ImageObjectsTable.COLUMN_IMAGE_URL))
        val annotation = cursor.getString(cursor.getColumnIndexOrThrow(ImageObjectsTable.COLUMN_NAME))
        val categoryName = cursor.getString(cursor.getColumnIndexOrThrow(ImageObjectsTable.COLUMN_CATEGORY))
        val accepted = cursor.getInt(cursor.getColumnIndexOrThrow(ImageObjectsTable.COLUMN_ACCEPTED))
        this.objectId = objectId
        this.imageFile = File(imageFilePath)
        this.annotation = annotation
        this.categoryName = categoryName
        this.accepted = accepted == 1
    }

    constructor(imageFile: File, annotation: String, categoryName: String)
    : this(imageFile, annotation, categoryName, false)

    private constructor(imageFile: File, annotation: String, categoryName: String, accepted: Boolean) {
        this.imageFile = imageFile
        this.annotation = annotation
        this.categoryName = categoryName
        this.objectId = null
        this.accepted = accepted
    }

    fun accepted() : ImageObject {
        return ImageObject(imageFile, annotation, categoryName, true)
    }

    fun toContentValues(): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(ImageObjectsTable.COLUMN_NAME, annotation)
        contentValues.put(ImageObjectsTable.COLUMN_IMAGE_URL, imageFile.absolutePath)
        contentValues.put(ImageObjectsTable.COLUMN_CATEGORY, categoryName)
        contentValues.put(ImageObjectsTable.COLUMN_ACCEPTED, if(accepted) 1 else 0)
        return contentValues
    }
}
