package pl.edu.pjwstk.presentation.dagger;

import android.content.Context;
import javax.inject.Singleton;
import dagger.Component;
import pl.edu.pjwstk.domain.hardware.CameraRepository;

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
