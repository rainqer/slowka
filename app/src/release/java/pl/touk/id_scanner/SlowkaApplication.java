package pl.touk.id_scanner;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
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
