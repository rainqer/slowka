package pl.edu.pjwstk.slowka.domain.content

import android.database.Cursor

interface ImageObjectRepository {

    fun getAll(): Cursor
    fun getImagesInCategory(categoryName: String): Cursor
    fun edit(id: String, imageObject: ImageObject) : Boolean
    fun insert(imageObject: ImageObject) : Boolean
    fun delete(id: String) : Boolean
}
