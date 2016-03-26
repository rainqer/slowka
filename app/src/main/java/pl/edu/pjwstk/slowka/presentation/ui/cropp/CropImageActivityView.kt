package pl.edu.pjwstk.slowka.presentation.ui.cropp

import android.graphics.Bitmap

interface CropImageActivityView {
    val croppedImage: Bitmap
    fun showImage (bitmap: Bitmap)
}
