package pl.edu.pjwstk.slowka.repository.translate;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface YandexService {

    @GET("translate")
    Observable<TranslationResult> translate(@Query("text") String textToTranslate,
                                            @Query("lang") String translateTo,
                                            @Query("key") String apiKey);

}
