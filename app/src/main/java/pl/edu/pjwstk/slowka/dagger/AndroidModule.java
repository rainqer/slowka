package pl.edu.pjwstk.slowka.dagger;

import android.app.Application;
import android.content.Context;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import pl.touk.id_scanner.SlowkaApplication;

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
