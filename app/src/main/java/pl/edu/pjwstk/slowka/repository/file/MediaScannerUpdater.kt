package pl.edu.pjwstk.slowka.repository.file

import android.content.Context
import android.content.Intent
import android.net.Uri
import java.io.File
import javax.inject.Inject

open class MediaScannerUpdater @Inject constructor(private val context: Context) {

    open fun update(imageFile: File) {
        context.sendBroadcast(
                Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
                        .setData(Uri.fromFile(imageFile))
        )
    }
}
