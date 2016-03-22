package pl.edu.pjwstk.slowka.presentation.ui.recognize

import android.graphics.Bitmap

interface RecognizeImageActivityView {

    open fun showAnnotationForRecognizedImage(annotationForImage: String)
    open fun setImage(bitmap: Bitmap)
}