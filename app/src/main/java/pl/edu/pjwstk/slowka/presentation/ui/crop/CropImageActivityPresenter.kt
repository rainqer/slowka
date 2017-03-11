package pl.edu.pjwstk.slowka.presentation.ui.crop

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.tools.Galery
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
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
            recognizeImageThenStoreOverwrittenBitmapWithAnnotation()
        } else {
            requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, WRITE_TO_SD_CARD_REQUEST_PERMISSION)
        }
    }

    private fun recognizeImageThenStoreOverwrittenBitmapWithAnnotation() {
        presentedView.showProgressBar()
        cropActivityModel.overwriteBitmapInFile(presentedView.croppedImage, fileWithBitmap)
                .flatMap { destinationFile ->
                    cropActivityModel.recognizeObjectInImage(destinationFile).map { annotation -> Pair(destinationFile, annotation) }
                }
                .flatMap { pairOfValues ->
                    cropActivityModel.storeReadyImageObject(buildImageObject(pairOfValues.first, pairOfValues.second))
                }.subscribe {
            presentedActivity.finish()
        }
    }

    private fun buildImageObject(file: File, imageAnnotation: String)
            = ImageObject(file, imageAnnotation, Category.HOME)

    override fun resume() {
        presentedView.showImage(Galery(presentedActivity).getScaledDownImage(fileWithBitmap))
    }

    override fun pause() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (requestCode == WRITE_TO_SD_CARD_REQUEST_PERMISSION){
                recognizeImageThenStoreOverwrittenBitmapWithAnnotation()
            }
        }
    }
}
