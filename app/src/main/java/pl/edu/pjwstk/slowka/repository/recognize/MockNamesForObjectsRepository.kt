package pl.edu.pjwstk.slowka.repository.recognize

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.vision.v1.Vision
import com.google.api.services.vision.v1.VisionRequestInitializer
import com.google.api.services.vision.v1.model.AnnotateImageRequest
import com.google.api.services.vision.v1.model.BatchAnnotateImagesRequest
import com.google.api.services.vision.v1.model.Feature
import com.google.api.services.vision.v1.model.Image
import pl.edu.pjwstk.slowka.domain.information.NamesForObjectInImageRepository
import java.io.ByteArrayOutputStream
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockNamesForObjectsRepository @Inject constructor() : NamesForObjectInImageRepository {

    override fun getNamesFor(file: File): Array<String> {
        return arrayOf("brick", "clay", "red stuff")
    }
}
