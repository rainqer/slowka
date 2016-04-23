package pl.edu.pjwstk.slowka.presentation.ui.crop

import android.graphics.Bitmap

interface CropImageActivityView {
    val croppedImage: Bitmap
    fun showImage (bitmap: Bitmap)
}
