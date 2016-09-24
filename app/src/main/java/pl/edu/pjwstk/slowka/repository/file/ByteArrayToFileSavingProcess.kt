package pl.edu.pjwstk.slowka.repository.file

import android.graphics.*
import android.media.ExifInterface
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import timber.log.Timber

class ByteArrayToFileSavingProcess(data: ByteArray, private val fileName: String, sizeRect: Rect) : FileSavingProcess<YuvImage>(fileName) {

    private val data: ByteArray
    private val sizeRect: Rect

    init {
        this.data = checkNotNull(data)
        this.sizeRect = checkNotNull(sizeRect)
    }

    fun save() : File {
        return super.save(YuvImage(data, ImageFormat.NV21, sizeRect.width(), sizeRect.height(), null))
    }

    @Throws(IOException::class)
    override fun flushDataIntoFile(dataOfType: YuvImage, out: FileOutputStream) {
        dataOfType.compressToJpeg(sizeRect, 100, out)
        out.flush()
    }

    override fun finally(dataOfType: YuvImage, imageFile: File) {
        // NO OP
        val exif = ExifInterface(imageFile.absolutePath);
        exif.setAttribute(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_ROTATE_90.toString());
        exif.saveAttributes();
    }
}
