package pl.edu.pjwstk.slowka.presentation.dagger;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.Category;
import pl.edu.pjwstk.slowka.domain.content.CategoryRepository;
import pl.edu.pjwstk.slowka.domain.content.ImageObject;
import pl.edu.pjwstk.slowka.domain.content.ImageObjectRepository;
import pl.edu.pjwstk.slowka.domain.file.FileRepository;
import pl.edu.pjwstk.slowka.domain.hardware.CameraRepository;
import pl.edu.pjwstk.slowka.domain.information.NamesForObjectInImageRepository;
import pl.edu.pjwstk.slowka.domain.test.TestRepository;
import pl.edu.pjwstk.slowka.repository.LocalMemoryTestRepository;
import pl.edu.pjwstk.slowka.repository.camera.AndroidCameraRepository;
import pl.edu.pjwstk.slowka.repository.content.LocalCategoryRepository;
import pl.edu.pjwstk.slowka.repository.content.LocalImageObjectRepository;
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
    ImageObjectRepository provideImageObjectRepository(LocalImageObjectRepository imageObjectRepository) {
        return imageObjectRepository;
    }

    @Provides
    @Singleton
    CategoryRepository provideCategoryRepository(LocalCategoryRepository categoryRepository) {
        return categoryRepository;
    }

    @Provides
    @Singleton
    TestRepository provideTestRepository(ImageObjectRepository imageObjectRepository) {
        return new LocalMemoryTestRepository(imageObjectRepository);
    }
}
