package pl.edu.pjwstk.slowka.domain.content

import android.database.Cursor

interface ImageObjectRepository {

    fun getAll(): Cursor
    fun getAllPending(): Cursor
    fun get(objectId: Int): Cursor
    fun getAcceptedImagesInCategory(categoryName: String): Cursor
    fun edit(id: String, imageObject: ImageObject) : Boolean
    fun insert(imageObject: ImageObject) : Boolean
    fun delete(id: String) : Boolean
    fun markAsKnown(id: Int) : Boolean
}
