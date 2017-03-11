package pl.edu.pjwstk.slowka.presentation.ui.crop

import android.graphics.Bitmap
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.content.StoreImageObjectUseCase
import pl.edu.pjwstk.slowka.domain.file.SaveBitmapUseCase
import pl.edu.pjwstk.slowka.domain.information.GetNamesForObjectInImageUseCase
import pl.edu.pjwstk.slowka.presentation.ui.crop.dagger.CropImageActivityScope
import rx.Observable
import rx.schedulers.Schedulers
import java.io.File
import javax.inject.Inject

@CropImageActivityScope
class CropActivityModel @Inject constructor(
        private val saveBitmapUseCase: SaveBitmapUseCase,
        private val getNamesForObjectInImageUseCase: GetNamesForObjectInImageUseCase,
        private val storeImageObjectUseCase: StoreImageObjectUseCase
    ) {

    fun overwriteBitmapInFile(croppedImage: Bitmap, fileWithBitmap: File): Observable<File> {
        return saveBitmapUseCase
                .bitmap(croppedImage)
                .toFile(fileWithBitmap)
                .performAndObserve(Schedulers.computation())
    }

    fun recognizeObjectInImage(file: File) : Observable<String> {
        return getNamesForObjectInImageUseCase.inImageFrom(file).performAndObserve(Schedulers.io())
    }

    fun storeReadyImageObject(imageObject: ImageObject) : Observable<Boolean> {
        return storeImageObjectUseCase.image(imageObject).performAndObserve(Schedulers.io())
    }
}
