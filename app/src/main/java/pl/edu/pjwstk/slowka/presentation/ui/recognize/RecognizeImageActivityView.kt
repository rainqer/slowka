package pl.edu.pjwstk.slowka.presentation.ui.recognize

import android.graphics.Bitmap

interface RecognizeImageActivityView {

    val imageAnnotation: String
    open fun showAnnotationForRecognizedImage(annotationForImage: String)
    open fun applyCategoryAdapter(newCategoryAdapter: CategoryAdapter)
    open fun setImage(bitmap: Bitmap)
    open fun getSelectedCategory(): String
}