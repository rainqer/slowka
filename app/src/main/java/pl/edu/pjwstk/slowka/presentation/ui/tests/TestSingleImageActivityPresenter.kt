package pl.edu.pjwstk.slowka.presentation.ui.tests

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.tools.Galery
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.complete_tests.CompleteTestActivity

class TestSingleImageActivityPresenter constructor(
        val recognizeImageActivityModel: TestSingleImageModel
    ) : ActivityPresenter<TestSingleImageActivityView>() {

    private var testedImageObject: ImageObject? = null

    override fun attach(view: TestSingleImageActivityView,
                        activity: FragmentActivity,
                        savedInstanceState: Bundle?) {
        super.attach(view, activity, savedInstanceState)
    }

    override fun resume() {
        recognizeImageActivityModel.getNextTestImageObject().subscribe { imageObject ->
            testedImageObject = imageObject
            presentedView.showImage(Galery(presentedActivity).getScaledDownImage(imageObject.imageFile))
            presentedView.adjustKeyboard(imageObject.annotation)
        }
    }

    override fun pause() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }

    fun onOkayClicked() {
        presentedView.showResult(testedImageObject?.annotation.equals(presentedView.getAnswer(), true))
    }

    fun onNextClicked() {
        recognizeImageActivityModel
                .uploadUserAnswer(presentedView.getAnswer(), testedImageObject)
                .subscribe { finished ->
                    startActivity(
                            if (finished) CompleteTestActivity.createIntent(presentedActivity)
                            else TestSingleImageActivity.createIntent(presentedActivity)
                    )
                    presentedActivity.finish()
                }
    }

    companion object {
        val CATEGORY_KEY = "categoryKey"
    }
}
