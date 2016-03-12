package pl.edu.pjwstk.slowka;

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
