package pl.edu.pjwstk.repository.recognize

import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.vision.v1.Vision
import com.google.api.services.vision.v1.VisionRequestInitializer
import pl.edu.pjwstk.BuildConfig
import pl.edu.pjwstk.domain.information.NamesForObjectInImageRepository
import pl.edu.pjwstk.repository.recognize.dto.GoogleVisionApiRequest
import pl.edu.pjwstk.repository.recognize.dto.Image
import retrofit.RestAdapter
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoogleVisionNamesForObjectsRepository @Inject constructor(
        val errorHandler : GoogleVisionApiHandler
) : NamesForObjectInImageRepository {

    override fun getNamesFor(file: File): Array<String> {
        // TODO
        //https://github.com/GoogleCloudPlatform/cloud-vision/tree/master/android/CloudVision/app
        return arrayOf("aaa")
    }

    private fun a() {
        val httpTransport = AndroidHttp.newCompatibleTransport();
        val jsonFactory = GsonFactory.getDefaultInstance();

        val builder = Vision.Builder(httpTransport, jsonFactory, null);
        builder.setVisionRequestInitializer(VisionRequestInitializer(CLOUD_VISION_API_KEY));
        Vision vision = builder.build();
    }


}
