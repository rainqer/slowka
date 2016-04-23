package pl.edu.pjwstk.slowka.presentation.ui.crop

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import pl.edu.pjwstk.slowka.domain.tools.BitmapDecoder
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.crop.CropActivityModel
import pl.edu.pjwstk.slowka.presentation.ui.crop.CropImageActivity
import pl.edu.pjwstk.slowka.presentation.ui.crop.CropImageActivityView
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivity
import java.io.File

class CropImageActivityPresenter constructor (
        private val cropActivityModel: CropActivityModel
    ) : ActivityPresenter<CropImageActivityView>() {

    private val WRITE_TO_SD_CARD_REQUEST_PERMISSION: Int = 224;
    private lateinit var fileWithBitmap: File

    override fun attach(view: CropImageActivityView,
                        activity: FragmentActivity,
                        savedInstanceState: Bundle?) {

        super.attach(view, activity, savedInstanceState)
        extractInfoFromIntent()
    }

    private fun extractInfoFromIntent() {
        fileWithBitmap = File(presentedActivity.intent.getStringExtra(CropImageActivity.Companion.FILE_NAME_KEY))
    }

    fun cropButtonClicked() {
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
