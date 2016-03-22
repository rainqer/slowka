package pl.edu.pjwstk.slowka.presentation.presenter.recognize

import android.app.Activity
import android.os.Bundle
import pl.edu.pjwstk.slowka.presentation.model.recognize.RecognizeImageModel
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivity
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivityView
import java.io.File

class RecognizeImageActivityPresenterImpl constructor(
        val recognizeImageActivityModel: RecognizeImageModel
    ) : RecognizeImageActivityPresenter() {

    private lateinit var file : File

    override fun attach(activityView: RecognizeImageActivityView,
                        activity: Activity,
                        savedInstanceState: Bundle?) {
        super.attach(activityView, activity, savedInstanceState)
        extractInfoFromIntent()
    }

    private fun extractInfoFromIntent() {
        file = File(presentedActivity.intent.getStringExtra(RecognizeImageActivity.Companion.FILE_NAME_KEY))
    }

    override fun resume() {
        recognizeImageActivityModel.recognizeObjectInImage(file).subscribe { annotationsForTheImage ->
            presentedView.showAnnotationForRecognizedImage(annotationsForTheImage[0])
        }
    }

    override fun pause() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }
}
