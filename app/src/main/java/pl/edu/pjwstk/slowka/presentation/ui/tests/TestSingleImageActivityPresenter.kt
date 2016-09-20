package pl.edu.pjwstk.slowka.presentation.ui.tests

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.tools.BitmapDecoder
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter

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
            presentedView.showImage(BitmapDecoder(imageObject.imageFile).decode())
        }
    }

    override fun pause() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }

    fun onNextClicked() {
        recognizeImageActivityModel
                .uploadUserAnswer(presentedView.getAnswer(), testedImageObject)
                .subscribe { finished ->
            if (finished) {
                presentedActivity.finish()
            } else {
                startActivity(TestSingleImageActivity.createIntent(presentedActivity))
            }
        }
    }

    companion object {
        val CATEGORY_KEY = "categoryKey"
    }
}
