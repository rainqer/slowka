package pl.edu.pjwstk.slowka.domain.test

import pl.edu.pjwstk.slowka.domain.UseCase
import pl.edu.pjwstk.slowka.domain.content.Category

class UserStartsTestForCategoryUseCase : UseCase<Boolean> {

    private val testRepository: TestRepository
    private val category: Category?

    constructor(testRepository: TestRepository) : this(testRepository, null)

    constructor(testRepository: TestRepository,
                category: Category?) : super() {
        this.testRepository = testRepository
        this.category = category
    }

    fun category(category: Category): UserStartsTestForCategoryUseCase {
        return UserStartsTestForCategoryUseCase(testRepository, category)
    }

    override fun perform(): Boolean {
        if (category == null) throw IllegalStateException("You did not provide category")
        return testRepository.startNewTestForCategory(category)
    }
}
