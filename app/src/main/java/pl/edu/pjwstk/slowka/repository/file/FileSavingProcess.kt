package pl.edu.pjwstk.slowka.repository.file

import android.os.Environment
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

abstract class FileSavingProcess <T: Any> constructor (fileName: String) {

    private val fileName: String

    init {
        this.fileName = checkNotNull(fileName)
    }

    abstract protected fun flushDataIntoFile(dataOfType: T, out: FileOutputStream)
    abstract protected fun finally(dataOfType: T, imageFile: File)

    fun save(dataOfType: T): File {
        val imageFileFolder = prepareImageFolder()
        val imageFile = prepareImageFile(imageFileFolder)
        return saveToFile(dataOfType, imageFile)
    }

    private fun prepareImageFolder(): File {
        val imageFileFolder = File(Environment.getExternalStorageDirectory(), ID_SCANNER_FOLDER)
        if (!imageFileFolder.exists()) {
            imageFileFolder.mkdir()
        }
        return imageFileFolder
    }

    private fun prepareImageFile(imageFileFolder: File): File {
        val imageFile = File(imageFileFolder, getFileName())
        if (imageFile.exists()) {
            imageFile.delete()
        }
        return imageFile
    }

    private fun getFileName() : String {
        return if (fileName.endsWith(EXTENSION)) {
            fileName
        } else {
            fileName + EXTENSION
        }
    }

    private fun saveToFile(dataOfType: T, imageFile: File): File {
        var resultFile: File = imageFile
        var out: FileOutputStream? = null
        try {
            out = FileOutputStream(imageFile)
            flushDataIntoFile(dataOfType, out)
        } finally {
            finally(dataOfType, imageFile)
            tryClosingOutputStream(out)
        }
        return resultFile
    }

    private fun tryClosingOutputStream(out: FileOutputStream?) {
        try {
            out?.close()
        } catch (exception: IOException) {
            Timber.e(exception, FileSavingProcess.Companion.TAG)
        }
    }

    companion object {
        private val TAG = "PhotoSavingProcess"
        private val ID_SCANNER_FOLDER = "dictionary"
        private val EXTENSION = ".jpg"
    }
}
