package pl.edu.pjwstk.slowka.presentation;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import pl.edu.pjwstk.slowka.presentation.dagger.AndroidModule;
import pl.edu.pjwstk.slowka.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.dagger.DaggerApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.dagger.RepositoriesModule;
import pl.edu.pjwstk.slowka.presentation.dagger.UsecasesModule;

public abstract class BaseApplication extends Application {


    protected ApplicationComponent component;
    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        component = provideDependencyComponent();
        provideLogging();
        provideCrashlytics();
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    protected void provideCrashlytics() {
    }

    protected abstract void provideLogging();

    public ApplicationComponent getComponent() {
        return component;
    }

    protected ApplicationComponent provideDependencyComponent() {
         return DaggerInitializer.init();
    }

    private final static class DaggerInitializer {
        private static ApplicationComponent init() {
            return DaggerApplicationComponent.builder()
                    .androidModule(new AndroidModule())
                    .repositoriesModule(new RepositoriesModule())
                    .usecasesModule(new UsecasesModule())
                    .build();
        }
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
