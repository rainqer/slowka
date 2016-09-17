package pl.edu.pjwstk.slowka.domain.test

import pl.edu.pjwstk.slowka.domain.UseCase
import pl.edu.pjwstk.slowka.domain.content.ImageObject

class UserViewNextTestImageUseCase(private val testRepository: TestRepository)
    : UseCase<ImageObject>() {

    override fun perform(): ImageObject {
        return testRepository.getNextImageFromCurrentTest()
    }
}
