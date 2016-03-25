package pl.edu.pjwstk.slowka.repository.file

import android.graphics.Bitmap
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class BitmapToFileSavingProcess(bitmap: Bitmap, fileName: String) : FileSavingProcess<Bitmap> (fileName) {

    private val bitmap: Bitmap
    private val fileName: String

    init {
        this.bitmap = checkNotNull(bitmap)
        this.fileName = checkNotNull(fileName)
    }

    fun save(): File {
        return super.save(bitmap)
    }

    @Throws(IOException::class)
    override fun flushDataIntoFile(dataOfType: Bitmap, out: FileOutputStream) {
        dataOfType.compress(Bitmap.CompressFormat.JPEG, 100, out)
        out.flush()
    }

    override fun finally(dataOfType: Bitmap) {
        bitmap.recycle()
    }
}
