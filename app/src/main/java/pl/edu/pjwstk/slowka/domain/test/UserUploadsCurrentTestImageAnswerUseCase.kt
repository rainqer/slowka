package pl.edu.pjwstk.slowka.domain.test

import pl.edu.pjwstk.slowka.domain.UseCase
import pl.edu.pjwstk.slowka.domain.content.ImageObject

class UserUploadsCurrentTestImageAnswerUseCase : UseCase<Boolean> {

    private val testRepository: TestRepository
    private val answer: String?
    private val imageObject: ImageObject?

    constructor(testRepository: TestRepository) : this(testRepository, null, null)

    constructor(testRepository: TestRepository,
                answer: String?,
                imageObject: ImageObject?) : super() {
        this.testRepository = testRepository
        this.answer = answer
        this.imageObject = imageObject
    }

    fun answer(answer: String): UserUploadsCurrentTestImageAnswerUseCase {
        return UserUploadsCurrentTestImageAnswerUseCase(testRepository, answer, imageObject)
    }

    fun imageObject(imageObject: ImageObject?): UserUploadsCurrentTestImageAnswerUseCase {
        return UserUploadsCurrentTestImageAnswerUseCase(testRepository, answer, imageObject)
    }

    override fun perform(): Boolean {
        if (answer == null) throw IllegalStateException("You did not provide answer")
        if (imageObject == null) throw IllegalStateException("You did not provide imageObject")
        return testRepository.uploadAnswerForImage(imageObject, answer)
    }
}
