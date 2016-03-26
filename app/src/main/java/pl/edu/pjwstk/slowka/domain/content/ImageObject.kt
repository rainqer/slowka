package pl.edu.pjwstk.slowka.domain.content

import android.content.ContentValues
import pl.edu.pjwstk.slowka.repository.content.ImageObjectsTable
import java.io.File

class ImageObject (val imageFile: File, val annotation: String) {

    fun toContentValues(): ContentValues? {
        val contentValues = ContentValues()
        contentValues.put(ImageObjectsTable.COLUMN_NAME, annotation)
        contentValues.put(ImageObjectsTable.COLUMN_IMAGE_URL, imageFile.absolutePath)
        return contentValues
    }
}
