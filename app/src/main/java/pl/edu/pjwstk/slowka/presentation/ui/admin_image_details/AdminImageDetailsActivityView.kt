package pl.edu.pjwstk.slowka.presentation.ui.admin_image_details

import android.support.v4.widget.CursorAdapter
import pl.edu.pjwstk.slowka.domain.content.ImageObject

interface AdminImageDetailsActivityView {

    val imageAnnotation: String
    fun applyCategoryAdapter(cursorAdapter: CursorAdapter)
    fun getSelectedCategory() : String
    fun showImageObject(imageObject: ImageObject)
    fun setRestoreButtonVisibility(shouldShowRestoreButton: Boolean)
}