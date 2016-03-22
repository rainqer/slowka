package pl.edu.pjwstk.slowka.presentation.dagger;

import android.app.Application;
import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.SlowkaApplication;

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
}
