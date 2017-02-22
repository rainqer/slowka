package pl.edu.pjwstk.slowka.presentation.ui.tests

import android.graphics.Bitmap

interface TestSingleImageActivityView {
    fun showImage(image: Bitmap)
    fun getAnswer(): String
    fun adjustKeyboard(annotation: String)
}