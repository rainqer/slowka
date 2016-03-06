package pl.touk.id_scanner;

import pl.edu.pjwstk.slowka.BaseApplication;
import timber.log.Timber;

public class SlowkaApplication extends BaseApplication {

    @Override
    protected void provideLogging() {
        Timber.plant(new Timber.DebugTree());
    }

//    @Override
//    protected void provideCrashlytics() {
//        Do not provide crashlytics in debug mode
//    }
}
