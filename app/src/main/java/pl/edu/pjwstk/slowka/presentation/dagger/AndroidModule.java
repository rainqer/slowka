package pl.edu.pjwstk.slowka.presentation.dagger;

import android.app.Application;
import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.SlowkaApplication;
import pl.edu.pjwstk.slowka.presentation.speech.Speaker;

@Module
public class AndroidModule {

    @Provides
    @Singleton
    Application provideApplication() {
        return SlowkaApplication.getInstance();
    }

    @Provides
    @Singleton
    Context provideContext() {
        return provideApplication();
    }

    @Provides
    @Singleton
    Speaker provideSpeaker(Context context) {
        return new Speaker(context);
    }
}
