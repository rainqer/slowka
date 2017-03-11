package pl.edu.pjwstk.slowka.repository.recognize

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.vision.v1.Vision
import com.google.api.services.vision.v1.VisionRequestInitializer
import com.google.api.services.vision.v1.model.*
import pl.edu.pjwstk.slowka.domain.information.NamesForObjectInImageRepository
import pl.edu.pjwstk.slowka.domain.tools.BitmapDecoder
import java.io.ByteArrayOutputStream
import java.io.File
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoogleVisionNamesForObjectsRepository @Inject constructor() : NamesForObjectInImageRepository {

//    final val DEBUG_VISION_API_KEY = "AIzaSyBZTiseELC1bqRqLtHZb5ua6ZNYOnKMlTQ" //android
    final val DEBUG_VISION_API_KEY = "AIzaSyCMy1TSJvgaCZEWebTRqobkAhqfaY_J5bo" //none

    override fun getNamesFor(file: File): Array<String> {
        // TODO
        // DONE
        //https://github.com/GoogleCloudPlatform/cloud-vision/tree/master/android/CloudVision/app
        return a(file)
    }

    private fun a(file: File): Array<String> {
        val httpTransport = AndroidHttp.newCompatibleTransport()
        val jsonFactory = GsonFactory.getDefaultInstance()

        val builder = Vision.Builder(httpTransport, jsonFactory, null)
        builder.setVisionRequestInitializer(VisionRequestInitializer(DEBUG_VISION_API_KEY))
        val vision = builder.build();
        val batchAnnotateImagesRequest = BatchAnnotateImagesRequest()
        batchAnnotateImagesRequest.requests = arrayListOf(getAnotateImageRequest(file))

        val annotateRequest = vision.images().annotate(batchAnnotateImagesRequest)
        annotateRequest.disableGZipContent = true
        val response = annotateRequest.execute()
        return convertResponseToString(response)
    }

    private fun convertResponseToString(response: BatchAnnotateImagesResponse): Array<String> {
        return response
                .responses[0]
                .labelAnnotations
                .map { label -> label.description }
                .toTypedArray()
    }

    private fun getAnotateImageRequest(file: File): AnnotateImageRequest {
        val annotateImageRequest = AnnotateImageRequest()

        // Add the image
        val base64EncodedImage = Image();
        // Convert the bitmap to a JPEG
        // Just in case it's a format that Android understands but Cloud Vision
        val byteArrayOutputStream = ByteArrayOutputStream();


        val bitmap = BitmapDecoder(file).decode()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream)
        val imageBytes = byteArrayOutputStream.toByteArray()

        // Base64 encode the JPEG
        base64EncodedImage.encodeContent(imageBytes)
        annotateImageRequest.setImage(base64EncodedImage)

        // add the features we want

        val labelDetection = Feature()
        labelDetection.setType("LABEL_DETECTION")
        labelDetection.setMaxResults(10)
        annotateImageRequest.setFeatures(arrayListOf(labelDetection))
        return annotateImageRequest
    }


}
