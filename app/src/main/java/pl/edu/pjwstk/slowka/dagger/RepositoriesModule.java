package pl.edu.pjwstk.slowka.dagger;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import pl.rhinoonabus.slowka.camera.AndroidCameraRepository;
import pl.rhinoonabus.slowka.hardware.CameraRepository;

@Module
public class RepositoriesModule {

    @Provides
    @Singleton
    CameraRepository provideCameraRepository(AndroidCameraRepository cameraRepository) {
        return cameraRepository;
    }

}
