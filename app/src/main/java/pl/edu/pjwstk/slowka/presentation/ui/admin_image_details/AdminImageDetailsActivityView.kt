package pl.edu.pjwstk.slowka.presentation.ui.admin_image_details

import pl.edu.pjwstk.slowka.domain.content.ImageObject

interface AdminImageDetailsActivityView {

    val imageAnnotation: String
    fun applyCategoryAdapter(newCategoryAdapter: CategoryAdapter)
    fun getSelectedCategory() : String
    fun showImageObject(imageObject: ImageObject)
}