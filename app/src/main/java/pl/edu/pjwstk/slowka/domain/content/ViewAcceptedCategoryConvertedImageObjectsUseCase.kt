package pl.edu.pjwstk.slowka.domain.content

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.UseCase

class ViewAcceptedCategoryConvertedImageObjectsUseCase : UseCase<List<ImageObject>> {

    private val imageObjectRepository: ImageObjectRepository
    private val categoryName: String?

    constructor(imageObjectRepository: ImageObjectRepository) : this(imageObjectRepository, null)

    private constructor(imageObjectRepository: ImageObjectRepository,
                        categoryName: String?) {
        this.imageObjectRepository = imageObjectRepository
        this.categoryName = categoryName
    }

    fun category(categoryName: String) : ViewAcceptedCategoryConvertedImageObjectsUseCase {
        return ViewAcceptedCategoryConvertedImageObjectsUseCase(imageObjectRepository, categoryName)
    }

    override fun perform(): List<ImageObject> {
        if (categoryName == null) {
            throw IllegalStateException("you must specify the categoryName")
        }
        return extractImages(imageObjectRepository.getAcceptedImagesInCategory(categoryName))
    }

    private fun extractImages(cursor: Cursor): List<ImageObject> {
        val imageObjects = mutableListOf<ImageObject>()
        if (cursor.moveToFirst())
        do {
            imageObjects.add(ImageObject(cursor))
        } while(cursor.moveToNext())
        return imageObjects
    }

}
