package pl.edu.pjwstk.repository.recognize

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
        val response = getGoogleVisionApi().annotateImage(buildRequest(file));
        return arrayOf("aaa")
    }

    private fun buildRequest(file: File): Array<out GoogleVisionApiRequest> {
        val request = GoogleVisionApiRequest()
        val image = Image()
        image.content = file.absolutePath
        request.image = image
        return arrayOf(request)
    }

    fun getGoogleVisionApi() : GoogleVisionApiService {
        val restAdapter = RestAdapter.Builder()
                .setEndpoint(GOOGLE_VISION_API_ENDPOINT)
                .setErrorHandler(errorHandler)
                .build()

        if (BuildConfig.DEBUG) {
            restAdapter.logLevel = RestAdapter.LogLevel.FULL
        }
        return restAdapter.create(GoogleVisionApiService::class.java)
    }

    companion object {
        final val GOOGLE_VISION_API_ENDPOINT = "https://vision.googleapis.com/v1/"
    }
}
