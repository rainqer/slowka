package pl.edu.pjwstk.slowka.presentation.dagger;

import android.content.Context;
import javax.inject.Singleton;
import dagger.Component;
import pl.edu.pjwstk.slowka.domain.file.FileRepository;
import pl.edu.pjwstk.slowka.domain.hardware.CameraRepository;
import pl.edu.pjwstk.slowka.domain.information.NamesForObjectInImageRepository;

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
        FileRepository providesFileRepository();
        NamesForObjectInImageRepository providesNamesForObjectInImageRepository();
}
