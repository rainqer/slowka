package pl.edu.pjwstk.slowka.presentation.presenter.cropp

import android.app.Activity
import android.graphics.Bitmap
import android.os.Bundle
import pl.edu.pjwstk.slowka.domain.tools.BitmapDecoder
import pl.edu.pjwstk.slowka.presentation.model.crop.CropActivityModel
import pl.edu.pjwstk.slowka.presentation.ui.cropp.CropImageActivity
import pl.edu.pjwstk.slowka.presentation.ui.cropp.CropImageActivityView
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivity
import java.io.File

class CropImageActivityPresenterImpl constructor (
        private val cropActivityModel: CropActivityModel
    ) : CropImageActivityPresenter() {

    private lateinit var fileWithBitmap: File

    override fun attach(activityView: CropImageActivityView,
                        activity: Activity,
                        savedInstanceState: Bundle?) {
        super.attach(activityView, activity, savedInstanceState)
        extractInfoFromIntent()
    }

    private fun extractInfoFromIntent() {
        fileWithBitmap = File(presentedActivity.intent.getStringExtra(CropImageActivity.FILE_NAME_KEY))
    }

    override fun cropButtonClicked(croppedImage: Bitmap) {
        cropActivityModel.overwriteBitmapInFile(croppedImage, fileWithBitmap)
                .subscribe { destinationFile ->
                    startActivity(RecognizeImageActivity.createIntent(presentedActivity, destinationFile))
                }
    }

    override fun resume() {
        presentedView.showImage(BitmapDecoder(fileWithBitmap).decode())
    }

    override fun pause() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }
}
