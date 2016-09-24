package pl.edu.pjwstk.slowka.domain.tools

import android.app.ActivityManager
import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.provider.MediaStore
import java.io.File

open class Galery(private val context: Context) {

    private var maxBitmapSizeOnCurrentDevice = -1

    private val BYTES_PER_PIXEL = 4
    private val BYTES_IN_MEGABYTE = 1024 * 1024
    private val MEMORY_LIMIT_FACTOR = 10
    private val MAX_BITMAP_SIZE_ON_ALL_DEVICES = 1024 * 1024 * 4

    private val DEGREES_180 = 180f
    private val DEGREES_90 = 90f
    private val DEGREES_MINUS_90 = -90f

    fun getScaledDownImage(imageFile: File): Bitmap {
        val selectedBitmap = getBitmapInSampleSizeIfToBig(imageFile.absolutePath)
        return rotateBitmap(selectedBitmap, getOrientation(imageFile.absolutePath))
//        return rotateBitmap(selectedBitmap, getOrientationFromGalery(Uri.fromFile(imageFile)))
    }

    private fun getOrientationFromGalery(contentUri: Uri): Int {
        var cursor: Cursor? = null
        try {
            cursor = context.contentResolver.query(contentUri, arrayOf(MediaStore.Images.Media.DATA), null, null, null)
            var orientation = -1;
            val orientationColumn = arrayOf(MediaStore.Images.Media.ORIENTATION);
            if (cursor != null && cursor.moveToFirst()) {
                orientation = cursor.getInt(cursor.getColumnIndex(orientationColumn[0]));
            }
            return orientation
        } finally {
            if (cursor != null) {
                cursor.close()
            }
        }
    }

    private fun getOrientation(imagePath: String): Int {
        val exifInterface = ExifInterface(imagePath)
        return exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED)
    }

    private fun getBitmapInSampleSizeIfToBig(imagePath: String): Bitmap {
        val opts = BitmapFactory.Options()
        opts.inJustDecodeBounds = true
        BitmapFactory.decodeFile(imagePath, opts)

        opts.inSampleSize = 1
        var bitmapSizeInMegabytes = opts.outWidth * opts.outHeight * BYTES_PER_PIXEL / BYTES_IN_MEGABYTE
        val maxBitmapSizeOnCurrentDevice = getMaxBitmapSizeOnCurrentDevice()
        while (bitmapSizeInMegabytes > maxBitmapSizeOnCurrentDevice) {
            opts.inSampleSize *= 2
            bitmapSizeInMegabytes /= opts.inSampleSize
        }

        opts.inJustDecodeBounds = false
        return BitmapFactory.decodeFile(imagePath, opts)
    }

    private fun getMaxBitmapSizeOnCurrentDevice(): Int {
        if (maxBitmapSizeOnCurrentDevice == -1) {
            maxBitmapSizeOnCurrentDevice = getMaxImageSizeByMemoryClass()
        }
        return maxBitmapSizeOnCurrentDevice
    }

    private fun getMaxImageSizeByMemoryClass(): Int {
        val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val memoryClass = am.memoryClass
        val limitedMemory = memoryClass / MEMORY_LIMIT_FACTOR
        return if (limitedMemory < MAX_BITMAP_SIZE_ON_ALL_DEVICES) {
            limitedMemory
        } else {
            MAX_BITMAP_SIZE_ON_ALL_DEVICES
        }
    }

    private fun rotateBitmap(bitmap: Bitmap, orientation: Int): Bitmap {
        val matrix = Matrix()

        var bmRotated: Bitmap? = rotateBitmap(bitmap, orientation, matrix)

        if (bmRotated == null) {
            bmRotated = rotateBitmapIfNeeded(bitmap, matrix)
        }

        return bmRotated
    }

    private fun rotateBitmap(bitmap: Bitmap, orientation: Int, matrix: Matrix): Bitmap? {
        var bmRotated: Bitmap? = null
        when (orientation) {
            ExifInterface.ORIENTATION_NORMAL -> bmRotated = bitmap
            ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> matrix.setScale(-1f, 1f)
            ExifInterface.ORIENTATION_ROTATE_180 -> matrix.setRotate(DEGREES_180)
            ExifInterface.ORIENTATION_FLIP_VERTICAL -> {
                matrix.setRotate(DEGREES_180)
                matrix.postScale(-1f, 1f)
            }
            ExifInterface.ORIENTATION_TRANSPOSE -> {
                matrix.setRotate(DEGREES_90)
                matrix.postScale(-1f, 1f)
            }
            ExifInterface.ORIENTATION_ROTATE_90 -> matrix.setRotate(DEGREES_90)
            ExifInterface.ORIENTATION_TRANSVERSE -> {
                matrix.setRotate(DEGREES_MINUS_90)
                matrix.postScale(-1f, 1f)
            }
            ExifInterface.ORIENTATION_ROTATE_270 -> matrix.setRotate(DEGREES_MINUS_90)
            else -> bmRotated = bitmap
        }
        return bmRotated
    }

    private fun rotateBitmapIfNeeded(bitmap: Bitmap, matrix: Matrix): Bitmap {
        try {
            val bmRotated = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width,
                    bitmap.height, matrix, true)
            bitmap.recycle()
            return bmRotated
        } catch (e: OutOfMemoryError) {
            return bitmap
        }
    }
}