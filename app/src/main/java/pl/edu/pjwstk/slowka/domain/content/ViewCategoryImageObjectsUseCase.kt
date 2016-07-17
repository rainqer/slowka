package pl.edu.pjwstk.slowka.domain.content

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.UseCase

class ViewCategoryImageObjectsUseCase : UseCase<Cursor> {

    private val imageObjectRepository: ImageObjectRepository
    private val categoryId: Int?

    constructor(imageObjectRepository: ImageObjectRepository) : this(imageObjectRepository, null)

    private constructor(imageObjectRepository: ImageObjectRepository,
                        categoryId: Int?) {
        this.imageObjectRepository = imageObjectRepository
        this.categoryId = categoryId
    }

    fun category(categoryId: Int) : ViewCategoryImageObjectsUseCase {
        return ViewCategoryImageObjectsUseCase(imageObjectRepository, categoryId)
    }

    override fun perform(): Cursor {
        if (categoryId == null) {
            throw IllegalStateException("you must specify the categoryId")
        }
        return imageObjectRepository.getAll()
    }

}
