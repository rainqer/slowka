package pl.edu.pjwstk.slowka.domain.content

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.UseCase

class ViewAllCategoriesUseCase : UseCase<Cursor> {

    private val categoryRepository: CategoryRepository

    constructor(categoryRepository: CategoryRepository) {
        this.categoryRepository = categoryRepository
    }

    override fun perform(): Cursor {
        return categoryRepository.getAll()
    }

}
