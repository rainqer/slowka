package pl.edu.pjwstk.slowka.presentation.ui.admin_image_details

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AlertDialog
import android.widget.Button
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.view.SimpleCursorAdapterForCategoryWithIcon

class AdminImageDetailsActivityPresenter constructor(
        val recognizeImageActivityModel: AdminImageDetailsModel
    ) : ActivityPresenter<AdminImageDetailsActivityView>() {

    private var imageObjectId : Int = -1
    private var shouldShowRestoreButton = false
    private var imageObjectAnnotation : String = ""

    override fun attach(view: AdminImageDetailsActivityView,
                        activity: FragmentActivity,
                        savedInstanceState: Bundle?) {
        super.attach(view, activity, savedInstanceState)
        extractInfoFromIntent()
        presentedView.setRestoreButtonVisibility(shouldShowRestoreButton)

    }

    private fun extractInfoFromIntent() {
        imageObjectId = presentedActivity.intent.getIntExtra(AdminImageDetailsActivity.IMAGE_OBJECT_NAME_KEY, -1)
        shouldShowRestoreButton = presentedActivity.intent
                .getBooleanExtra(AdminImageDetailsActivity.SHOULD_SHOW_RESTORE_KEY, false)
    }

    fun confirmButtonClicked() {
        recognizeImageActivityModel
                .updateImageObject(imageObjectId, presentedView.imageAnnotation, presentedView.getSelectedCategory())
                .subscribe { successful ->
            presentedActivity.finish()
        }
    }

    override fun resume() {
        recognizeImageActivityModel.getImageObject(imageObjectId).subscribe { imageObject ->
            imageObjectAnnotation = imageObject.annotation
            presentedView.showImageObject(imageObject)
        }
        recognizeImageActivityModel.getAllCategories().subscribe() { cursor ->
            presentedView.applyCategoryAdapter(SimpleCursorAdapterForCategoryWithIcon(presentedActivity, cursor, 0))
        }
    }

    override fun pause() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }

    fun restoreButtonClicked() {
        AlertDialog.Builder(presentedActivity)
                .setTitle(R.string.restore_dialog_title)
                .setMessage(presentedActivity.getString(R.string.restore_dialog_message, imageObjectAnnotation))
                .setPositiveButton(android.R.string.ok) { dialog, which ->
                    recognizeImageActivityModel.restoreImageToLearning(imageObjectId)
                }
                .show()
    }
}
