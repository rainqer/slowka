package pl.edu.pjwstk.repository.file

import android.graphics.*
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import timber.log.Timber

class ImageFileSavingProcess (data: ByteArray, fileName: String, sizeRect: Rect) {
    private val data: ByteArray
    private val fileName: String
    private val sizeRect: Rect

    init {
        this.data = checkNotNull(data)
        this.fileName = checkNotNull(fileName)
        this.sizeRect = checkNotNull(sizeRect)
    }

    fun save(): File {
        val img = YuvImage(data, ImageFormat.NV21, sizeRect.width(), sizeRect.height(), null);
        val imageFileFolder = prepareImageFolder()
        val imageFile = prepareImageFile(imageFileFolder)
        return saveToFile(img, imageFile)
    }

    private fun prepareImageFolder(): File {
        val imageFileFolder = File(Environment.getExternalStorageDirectory(), ID_SCANNER_FOLDER)
        if (!imageFileFolder.exists()) {
            imageFileFolder.mkdir()
        }
        return imageFileFolder
    }

    private fun prepareImageFile(imageFileFolder: File): File {
        val imageFile = File(imageFileFolder, fileName + EXTENSION)
        if (imageFile.exists()) {
            imageFile.delete()
        }
        return imageFile
    }

    private fun saveToFileAndRecycleBitmap(bitmap: Bitmap, imageFile: File): File {
        var resultFile: File = imageFile
        var out: FileOutputStream? = null
        try {
            out = FileOutputStream(imageFile)
            flushBitmapToOutputStream(bitmap, out)
        } finally {
            bitmap.recycle()
            tryClosingOutputStream(out)
        }
        return resultFile
    }

    private fun saveToFile(yuvImage: YuvImage, imageFile: File): File {
        var resultFile: File = imageFile
        var out: FileOutputStream? = null
        try {
            out = FileOutputStream(imageFile)
            flushYuvToOutputStream(yuvImage, out)
        } finally {
            tryClosingOutputStream(out)
        }
        return resultFile
    }

    @Throws(IOException::class)
    private fun flushBitmapToOutputStream(bitmap: Bitmap, out: FileOutputStream) {
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out)
        out.flush()
    }

    @Throws(IOException::class)
    private fun flushYuvToOutputStream(yuvImage: YuvImage, out: FileOutputStream) {
        yuvImage.compressToJpeg(sizeRect, 100, out)
        out.flush()
    }

    private fun tryClosingOutputStream(out: FileOutputStream?) {
        try {
            out?.close()
        } catch (exception: IOException) {
            Timber.e(exception, TAG)
        }
    }

    companion object {
        private val TAG = "PhotoSavingProcess"
        private val ID_SCANNER_FOLDER = "id-scanner"
        private val EXTENSION = ".jpg"
    }
}
