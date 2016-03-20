package pl.edu.pjwstk.presentation.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.domain.file.FileRepository;
import pl.edu.pjwstk.domain.hardware.CameraRepository;
import pl.edu.pjwstk.domain.information.NamesForObjectInImageRepository;
import pl.edu.pjwstk.repository.camera.AndroidCameraRepository;
import pl.edu.pjwstk.repository.file.AndroidFileRepository;
import pl.edu.pjwstk.repository.recognize.MockNamesForObjectsRepository;

@Module
public class RepositoriesModule {

    @Provides
    @Singleton
    CameraRepository provideCameraRepository(AndroidCameraRepository cameraRepository) {
        return cameraRepository;
    }

    @Provides
    @Singleton
    FileRepository provideFileRepository(AndroidFileRepository fileRepository) {
        return fileRepository;
    }

    @Provides
    @Singleton
    NamesForObjectInImageRepository provideNamesForObjectInImageRepository(MockNamesForObjectsRepository getNamesRepository) {
        return getNamesRepository;
    }
}
