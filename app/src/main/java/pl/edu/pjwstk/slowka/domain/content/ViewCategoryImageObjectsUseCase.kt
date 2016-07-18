package pl.edu.pjwstk.slowka.domain.content

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.UseCase

class ViewCategoryImageObjectsUseCase : UseCase<Cursor> {

    private val imageObjectRepository: ImageObjectRepository
    private val categoryName: String?

    constructor(imageObjectRepository: ImageObjectRepository) : this(imageObjectRepository, null)

    private constructor(imageObjectRepository: ImageObjectRepository,
                        categoryName: String?) {
        this.imageObjectRepository = imageObjectRepository
        this.categoryName = categoryName
    }

    fun category(categoryName: String) : ViewCategoryImageObjectsUseCase {
        return ViewCategoryImageObjectsUseCase(imageObjectRepository, categoryName)
    }

    override fun perform(): Cursor {
        if (categoryName == null) {
            throw IllegalStateException("you must specify the categoryName")
        }
        return imageObjectRepository.getImagesInCategory(categoryName)
    }

}
