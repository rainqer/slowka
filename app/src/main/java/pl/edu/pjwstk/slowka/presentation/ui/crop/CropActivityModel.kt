package pl.edu.pjwstk.slowka.presentation.ui.crop

import android.graphics.Bitmap
import pl.edu.pjwstk.slowka.domain.file.SaveBitmapUseCase
import pl.edu.pjwstk.slowka.presentation.ui.crop.dagger.CropImageActivityScope
import rx.Observable
import rx.schedulers.Schedulers
import java.io.File
import javax.inject.Inject

@CropImageActivityScope
class CropActivityModel @Inject constructor(
        private val saveBitmapUseCase: SaveBitmapUseCase
    ) {

    fun overwriteBitmapInFile(croppedImage: Bitmap, fileWithBitmap: File): Observable<File> {
        return saveBitmapUseCase
                .bitmap(croppedImage)
                .toFile(fileWithBitmap)
                .performAndObserve(Schedulers.computation())
    }
}
