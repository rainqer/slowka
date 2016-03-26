package pl.edu.pjwstk.slowka.presentation.presenter.cropp

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
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

    private val WRITE_TO_SD_CARD_REQUEST_PERMISSION: Int = 224;
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

    override fun cropButtonClicked() {
        if (permissionGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            proceedToRecognizeWithOverwrittenBitmap()
        } else {
            requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, WRITE_TO_SD_CARD_REQUEST_PERMISSION)
        }
    }

    private fun proceedToRecognizeWithOverwrittenBitmap() {
        cropActivityModel.overwriteBitmapInFile(presentedView.croppedImage, fileWithBitmap)
                .subscribe { destinationFile ->
                    startActivity(RecognizeImageActivity.createIntent(presentedActivity, destinationFile))
                    presentedActivity.finish()
                }
    }

    override fun resume() {
        presentedView.showImage(BitmapDecoder(fileWithBitmap).decode())
    }

    override fun pause() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (requestCode == WRITE_TO_SD_CARD_REQUEST_PERMISSION){
                proceedToRecognizeWithOverwrittenBitmap()
            }
        }
    }
}
