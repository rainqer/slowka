package pl.edu.pjwstk.slowka.presentation.ui.tests

import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.test.UserUploadsCurrentTestImageAnswerUseCase
import pl.edu.pjwstk.slowka.domain.test.UserViewNextTestImageUseCase
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

class TestSingleImageModel constructor(private val userViewNextTestImageUseCase: UserViewNextTestImageUseCase,
                                       private val userUploadsAnswerUseCase: UserUploadsCurrentTestImageAnswerUseCase) {

    fun getNextTestImageObject(): Observable<ImageObject> {
        return userViewNextTestImageUseCase.performAndObserve(AndroidSchedulers.mainThread())
    }

    fun uploadUserAnswer(answer: String, imageObject: ImageObject?): Observable<Boolean> {
        return userUploadsAnswerUseCase
                .answer(answer)
                .imageObject(imageObject)
                .performAndObserve(AndroidSchedulers.mainThread())
    }
}
