package pl.edu.pjwstk.slowka.domain.tools

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File

class BitmapDecoder (private val file: File) {

    fun decode() : Bitmap {
        return BitmapFactory.decodeFile(file.absolutePath, buildOptions())
    }

    private fun buildOptions(): BitmapFactory.Options {
        val options = BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888
        return options
    }
}
