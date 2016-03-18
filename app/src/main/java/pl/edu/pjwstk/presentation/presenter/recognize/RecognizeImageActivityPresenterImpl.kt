package pl.edu.pjwstk.presentation.presenter.recognize

import android.app.Activity
import android.os.Bundle
import pl.edu.pjwstk.presentation.model.recognize.RecognizeImageModel
import pl.edu.pjwstk.presentation.ui.camera.CameraActivityView
import pl.edu.pjwstk.presentation.ui.recognize.RecognizeImageActivity
import pl.edu.pjwstk.presentation.ui.recognize.RecognizeImageActivityView
import java.io.File

class RecognizeImageActivityPresenterImpl constructor(
        val recognizeImageActivityModel: RecognizeImageModel
    ) : RecognizeImageActivityPresenter() {

    private lateinit var cameraActivityView: CameraActivityView
    private lateinit var activity: Activity
    private lateinit var file : File

    override fun attach(activityView: RecognizeImageActivityView,
                        activity: Activity,
                        savedInstanceState: Bundle?) {
        this.activity = activity
        this.cameraActivityView = cameraActivityView
        extractInfoFromIntent()
    }

    private fun extractInfoFromIntent() {
        file = File(activity.intent.getStringExtra(RecognizeImageActivity.FILE_NAME_KEY))
    }

    override fun resume() {
        recognizeImageActivityModel.recognizeObjectInImage(file)
    }

    override fun pause() {
    }

}
