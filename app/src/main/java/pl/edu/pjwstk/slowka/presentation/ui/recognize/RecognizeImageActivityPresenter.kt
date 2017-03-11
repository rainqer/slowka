package pl.edu.pjwstk.slowka.presentation.ui.recognize

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentActivity
import android.widget.Toast
import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.tools.Galery
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
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
                .storeReadyImageObject(buildImageObject())
                .subscribe { successful ->
                    presentedActivity.finish()
                }
    }

    override fun resume() {
        presentedView.setImage(Galery(presentedActivity).getScaledDownImage(file))
        recognizeImageActivityModel.recognizeObjectInImage(file)
                .subscribe (
                        { annotationForTheImage -> presentedView.showAnnotationForRecognizedImage(annotationForTheImage)}
                )
    }

    private fun buildImageObject()
            = ImageObject(file, presentedView.imageAnnotation, Category.HOME)

    override fun pause() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }
}
