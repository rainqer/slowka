package pl.edu.pjwstk.slowka.presentation.ui.recognize

import android.graphics.Bitmap
import pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.CategoryAdapter

interface RecognizeImageActivityView {

    val imageAnnotation: String
    open fun showAnnotationForRecognizedImage(annotationForImage: String)
    open fun setImage(bitmap: Bitmap)
}