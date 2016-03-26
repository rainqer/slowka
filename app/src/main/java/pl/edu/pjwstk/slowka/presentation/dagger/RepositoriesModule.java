package pl.edu.pjwstk.slowka.presentation.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.ImageObjectRepository;
import pl.edu.pjwstk.slowka.domain.file.FileRepository;
import pl.edu.pjwstk.slowka.domain.hardware.CameraRepository;
import pl.edu.pjwstk.slowka.domain.information.NamesForObjectInImageRepository;
import pl.edu.pjwstk.slowka.repository.camera.AndroidCameraRepository;
import pl.edu.pjwstk.slowka.repository.content.AndroidImageObjectRepository;
import pl.edu.pjwstk.slowka.repository.file.AndroidFileRepository;
import pl.edu.pjwstk.slowka.repository.recognize.MockNamesForObjectsRepository;

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

    @Provides
    @Singleton
    ImageObjectRepository provideImageObjectRepository(AndroidImageObjectRepository imageObjectRepository) {
        return imageObjectRepository;
    }
}
