package pl.edu.pjwstk.slowka.presentation.ui.complete_tests

import pl.edu.pjwstk.slowka.domain.test.TestResult
import pl.edu.pjwstk.slowka.domain.test.UserCompletesTestUseCase
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

class CompleteTestModel constructor(private val userCompletesTestUseCase: UserCompletesTestUseCase) {

    fun completeCurrentTest(): Observable<TestResult> {
        return userCompletesTestUseCase.performAndObserve(AndroidSchedulers.mainThread())
    }
}
