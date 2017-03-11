package pl.edu.pjwstk.slowka.presentation.dagger;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import pl.edu.pjwstk.slowka.repository.translate.YandexService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceModule {

    private static final int HTTP_READ_WRITE_TIMEOUT = 30;

    @Provides
    YandexService providesTonsService(OkHttpClient okHttpClient, Gson gson) {
        final Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("https://translate.yandex.net/api/v1.5/tr.json/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(YandexService.class);
    }

    @Provides
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient()
                .newBuilder()
                .readTimeout(HTTP_READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(HTTP_READ_WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    Gson providesGson() {
        return new Gson();
    }
}
