package pl.edu.pjwstk.slowka.presentation.ui.recognize

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.Toast
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.tools.BitmapDecoder
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageModel
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivity
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivityView
import java.io.File

class RecognizeImageActivityPresenter constructor(
        val recognizeImageActivityModel: RecognizeImageModel
    ) : ActivityPresenter<RecognizeImageActivityView>() {

    private lateinit var file : File

    override fun attach(view: RecognizeImageActivityView,
                        activity: FragmentActivity,
                        savedInstanceState: Bundle?) {
        super.attach(view, activity, savedInstanceState)
        extractInfoFromIntent()
    }

    private fun extractInfoFromIntent() {
        file = File(presentedActivity.intent.getStringExtra(RecognizeImageActivity.FILE_NAME_KEY))
    }

    fun confirmButtonClicked() {
        recognizeImageActivityModel
                .storeReadyImageObject(ImageObject(file, presentedView.imageAnnotation))
                .subscribe { successful ->
                    Toast.makeText(presentedActivity, if (successful) "SUCCESS" else "FAIL" , Toast.LENGTH_LONG)
                    presentedActivity.finish()
                }
    }

    override fun resume() {
        presentedView.setImage(BitmapDecoder(file).decode())
        recognizeImageActivityModel.recognizeObjectInImage(file).subscribe { annotationsForTheImage ->
            presentedView.showAnnotationForRecognizedImage(annotationsForTheImage[0])
        }
    }

    override fun pause() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }
}
