package pl.edu.pjwstk.presentation.presenter.recognize

import android.app.Activity
import android.os.Bundle
import pl.edu.pjwstk.presentation.model.recognize.RecognizeImageModel
import pl.edu.pjwstk.presentation.ui.recognize.RecognizeImageActivity
import pl.edu.pjwstk.presentation.ui.recognize.RecognizeImageActivityView
import java.io.File

class RecognizeImageActivityPresenterImpl constructor(
        val recognizeImageActivityModel: RecognizeImageModel
    ) : RecognizeImageActivityPresenter() {

    override fun attach(activityView: RecognizeImageActivityView,
                        activity: Activity,
                        savedInstanceState: Bundle?) {

    }

    private fun extractInfoFromIntent() {
        file = File(.getStringExtra(RecognizeImageActivity.FILE_NAME_KEY))
    }

    override fun resume() {
        recognizeImageActivityModel.recognizeObjectInImage()
    }

    override fun pause() {
    }

}
