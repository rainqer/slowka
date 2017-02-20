package pl.edu.pjwstk.slowka.presentation.ui.admin_image_details

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.widget.SimpleCursorAdapter
import android.widget.Toast
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter

class AdminImageDetailsActivityPresenter constructor(
        val recognizeImageActivityModel: AdminImageDetailsModel
    ) : ActivityPresenter<AdminImageDetailsActivityView>() {

    private var imageObjectId : Int = -1

    override fun attach(view: AdminImageDetailsActivityView,
                        activity: FragmentActivity,
                        savedInstanceState: Bundle?) {
        super.attach(view, activity, savedInstanceState)
        extractInfoFromIntent()

    }

    private fun extractInfoFromIntent() {
        imageObjectId = presentedActivity.intent.getIntExtra(AdminImageDetailsActivity.IMAGE_OBJECT_NAME_KEY, -1)
    }

    fun confirmButtonClicked() {
        recognizeImageActivityModel
                .updateImageObject(imageObjectId, presentedView.imageAnnotation, presentedView.getSelectedCategory())
                .subscribe { successful ->
            Toast.makeText(presentedActivity, if (successful) "SUCCESS" else "FAIL" , Toast.LENGTH_LONG).show()
            presentedActivity.finish()
        }
    }

    override fun resume() {
        recognizeImageActivityModel.getImageObject(imageObjectId).subscribe { imageObject ->
            presentedView.showImageObject(imageObject)
        }
        recognizeImageActivityModel.getAllCategories().subscribe() { cursor ->
            val adapterCols=arrayOf("categoryName");
            val adapterRowViews= intArrayOf(android.R.id.text1);
            val cursorAdapter = SimpleCursorAdapter(presentedActivity, android.R.layout.simple_spinner_item, cursor, adapterCols, adapterRowViews, 0)
            cursorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            presentedView.applyCategoryAdapter(cursorAdapter)
        }
    }

    override fun pause() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }
}
