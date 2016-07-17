package pl.edu.pjwstk.slowka.presentation.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.CategoryRepository;
import pl.edu.pjwstk.slowka.domain.content.ImageObjectRepository;
import pl.edu.pjwstk.slowka.domain.content.StoreCategoryUseCase;
import pl.edu.pjwstk.slowka.domain.content.StoreImageObjectUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllCategoriesUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllImageObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewCategoryImageObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.file.FileRepository;
import pl.edu.pjwstk.slowka.domain.file.SaveBitmapUseCase;
import pl.edu.pjwstk.slowka.domain.file.SaveCameraFrameUseCase;
import pl.edu.pjwstk.slowka.domain.file.SaveCurrentCameraFrameUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.CameraRepository;
import pl.edu.pjwstk.slowka.domain.hardware.GetCurrentCameraFrameUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.LaunchCameraUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.PreviewCameraUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.StopCameraUseCase;
import pl.edu.pjwstk.slowka.domain.information.GetNamesForObjectInImageUseCase;
import pl.edu.pjwstk.slowka.domain.information.NamesForObjectInImageRepository;
import pl.edu.pjwstk.slowka.repository.file.MediaScannerUpdater;

@Module
public class UsecasesModule {

    @Provides
    StoreImageObjectUseCase providesStoreImageObjectUseCase(ImageObjectRepository imageObjectRepository) {
        return new StoreImageObjectUseCase(imageObjectRepository);
    }

    @Provides
    ViewAllImageObjectsUseCase providesViewAllImageObjectsUseCase(ImageObjectRepository imageObjectRepository) {
        return new ViewAllImageObjectsUseCase(imageObjectRepository);
    }

    @Provides
    ViewCategoryImageObjectsUseCase providesViewCategoryImageObjectsUseCase(ImageObjectRepository imageObjectRepository) {
        return new ViewCategoryImageObjectsUseCase(imageObjectRepository);
    }

    @Provides
    ViewAllCategoriesUseCase providesViewAllCategoriesUseCase(CategoryRepository categoryRepository) {
        return new ViewAllCategoriesUseCase(categoryRepository);
    }

    @Provides
    StoreCategoryUseCase providesStoreCategoryUseCase(CategoryRepository categoryRepository) {
        return new StoreCategoryUseCase(categoryRepository);
    }

    @Provides
    SaveBitmapUseCase providesSaveBitmapUseCase(FileRepository fileRepository, MediaScannerUpdater mediaScannerUpdater) {
        return new SaveBitmapUseCase(fileRepository, mediaScannerUpdater);
    }

    @Provides
    SaveCameraFrameUseCase providesSaveCameraFrameUseCase(FileRepository fileRepository, MediaScannerUpdater mediaScannerUpdater) {
        return new SaveCameraFrameUseCase(fileRepository, mediaScannerUpdater);
    }

    @Provides
    SaveCurrentCameraFrameUseCase providesSaveCurrentCameraFrameUseCase(CameraRepository cameraRepository, SaveCameraFrameUseCase saveCameraFrameUseCase) {
        return new SaveCurrentCameraFrameUseCase(cameraRepository, saveCameraFrameUseCase);
    }

    @Provides
    GetCurrentCameraFrameUseCase providesGetCurrentCameraFrameUseCase(CameraRepository cameraRepository) {
        return new GetCurrentCameraFrameUseCase(cameraRepository);
    }

    @Provides
    LaunchCameraUseCase providesLaunchCameraUseCase(CameraRepository cameraRepository) {
        return new LaunchCameraUseCase(cameraRepository);
    }

    @Provides
    PreviewCameraUseCase providesPreviewCameraUseCase(CameraRepository cameraRepository) {
        return new PreviewCameraUseCase(cameraRepository);
    }

    @Provides
    StopCameraUseCase providesStopCameraUseCase(CameraRepository cameraRepository) {
        return new StopCameraUseCase(cameraRepository);
    }

    @Provides
    GetNamesForObjectInImageUseCase providesGetNamesForObjectInImageUseCase(NamesForObjectInImageRepository namesForObjectInImageRepository) {
        return new GetNamesForObjectInImageUseCase(namesForObjectInImageRepository);
    }
}
