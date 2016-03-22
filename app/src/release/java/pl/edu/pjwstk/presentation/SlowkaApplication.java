package pl.edu.pjwstk.slowka.presentation;

import timber.log.Timber;

public class SlowkaApplication extends BaseApplication {

    @Override
    protected void provideLogging() {
        Timber.plant(new Timber.HollowTree());
    }

//    @Override
//    protected void provideCrashlytics() {
//        Fabric.with(this, new Crashlytics());
//    }
}
