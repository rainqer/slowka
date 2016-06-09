package pl.edu.pjwstk.slowka.presentation.ui.recognize

import android.graphics.Bitmap
import android.widget.ListAdapter

interface RecognizeImageActivityView {

    val imageAnnotation: String
    open fun showAnnotationForRecognizedImage(annotationForImage: String)
    open fun applyCategoryAdapter(categoryAdapter: ListAdapter)
    open fun setImage(bitmap: Bitmap)
}