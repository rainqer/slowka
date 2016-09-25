package pl.edu.pjwstk.slowka.domain.test

import pl.edu.pjwstk.slowka.domain.UseCase

class UserCompletesTestUseCase(private val testRepository: TestRepository)
    : UseCase<TestResult>() {

    override fun perform(): TestResult {
        return testRepository.finishCurrentTest()
    }
}
