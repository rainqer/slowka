package pl.edu.pjwstk.repository.recognize;

import pl.edu.pjwstk.repository.recognize.dto.GoogleVisionApiRequest;
import pl.edu.pjwstk.repository.recognize.dto.GoogleVisionApiResponse;
import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;

public interface GoogleVisionApiService {

    @POST("images:annotate")
    Observable<GoogleVisionApiResponse[]> annotateImage(@Body GoogleVisionApiRequest[] requests) throws Throwable;
}
