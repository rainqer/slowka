package pl.edu.pjwstk.slowka.presentation.dagger;

import android.app.Activity;
import android.app.Application;
import android.support.annotation.NonNull;

import pl.edu.pjwstk.slowka.presentation.SlowkaApplication;

public class Components {

    private Components() {
        throw new AssertionError("No instances.");
    }

    public static <T> T from(@NonNull Activity activity) {
        return ((HasComponent<T>) activity).getComponent();
    }

    public static ApplicationComponent from(@NonNull Application application) {
        return ((SlowkaApplication) application).getComponent();
    }
}
