package pl.edu.pjwstk.slowka.presentation.ui.admin_image_details

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.view.SimpleCursorAdapterForCategoryWithIcon

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
            presentedActivity.finish()
        }
    }

    override fun resume() {
        recognizeImageActivityModel.getImageObject(imageObjectId).subscribe { imageObject ->
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
}
