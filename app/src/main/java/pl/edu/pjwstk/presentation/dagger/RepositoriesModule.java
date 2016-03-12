package pl.edu.pjwstk.presentation.dagger;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.domain.hardware.CameraRepository;
import pl.edu.pjwstk.repository.camera.AndroidCameraRepository;

@Module
public class RepositoriesModule {

    @Provides
    @Singleton
    CameraRepository provideCameraRepository(AndroidCameraRepository cameraRepository) {
        return cameraRepository;
    }

}
