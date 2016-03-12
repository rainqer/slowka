package pl.edu.pjwstk.slowka.dagger;

import android.content.Context;
import javax.inject.Singleton;
import dagger.Component;
import pl.rhinoonabus.slowka.hardware.CameraRepository;

@Singleton
@Component(
        modules = {
                AndroidModule.class,
                RepositoriesModule.class
        }
)
public interface ApplicationComponent {
        Context providesContext();
        CameraRepository providesCameraRepository();
}
