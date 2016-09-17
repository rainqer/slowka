package pl.edu.pjwstk.slowka.domain.test

import pl.edu.pjwstk.slowka.domain.UseCase

class UserUploadsCurrentTestImageAnswerUseCase : UseCase<Boolean> {

    private val testRepository: TestRepository
    private val answer: String?

    constructor(testRepository: TestRepository) : this(testRepository, null)

    constructor(testRepository: TestRepository,
                answer: String?) : super() {
        this.testRepository = testRepository
        this.answer = answer
    }

    fun answer(answer: String): UserUploadsCurrentTestImageAnswerUseCase {
        return UserUploadsCurrentTestImageAnswerUseCase(testRepository, answer)
    }

    override fun perform(): Boolean {
        if (answer == null) throw IllegalStateException("You did not provide answer")
        return testRepository.uploadAnswerForImage(answer)
    }
}
