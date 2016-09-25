package pl.edu.pjwstk.slowka.presentation.ui.complete_tests

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter

class CompleteTestActivityPresenter constructor(
        val completeTestModel: CompleteTestModel
    ) : ActivityPresenter<CompleteTestActivityView>() {

    override fun attach(view: CompleteTestActivityView,
                        activity: FragmentActivity,
                        savedInstanceState: Bundle?) {
        super.attach(view, activity, savedInstanceState)
    }

    override fun resume() {
        completeTestModel.completeCurrentTest().subscribe { testResult->
            presentedView.setResults(testResult.correctAnswers, testResult.incorrectAnswers)
        }
    }

    override fun pause() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }
}
