package pl.edu.pjwstk.slowka.domain.content

import pl.edu.pjwstk.slowka.domain.UseCase

class StoreCategoryUseCase : UseCase<Boolean> {

    private val categoryRepository: CategoryRepository
    private val category: Category?

    constructor(categoryRepository: CategoryRepository) : this(categoryRepository, null)

    private constructor(categoryRepository: CategoryRepository, category: Category?) {
        this.categoryRepository = categoryRepository
        this.category = category;
    }

    override fun perform(): Boolean {
        if (category == null) {
            throw AssertionError("Category not specified")
        }
        return categoryRepository.insert(category)
    }

}
