package pl.edu.pjwstk.slowka.presentation.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.CategoryRepository;
import pl.edu.pjwstk.slowka.domain.content.CountAllImageObjectsWithCategoriesUseCase;
import pl.edu.pjwstk.slowka.domain.content.GetImageObjectUseCase;
import pl.edu.pjwstk.slowka.domain.content.ImageObjectRepository;
import pl.edu.pjwstk.slowka.domain.content.RestoreImageObjectToUnknownUseCase;
import pl.edu.pjwstk.slowka.domain.content.StoreCategoryUseCase;
import pl.edu.pjwstk.slowka.domain.content.StoreImageObjectUseCase;
import pl.edu.pjwstk.slowka.domain.content.UpdateImageObjectUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedCategoryImagesObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedKnownCategoryImagesObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedLearningCategoryImagesObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedUnknownImageObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllCategoriesUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllImageObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllPendingImageObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewKnownImageObjectsUseCase;
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
import pl.edu.pjwstk.slowka.domain.test.TestRepository;
import pl.edu.pjwstk.slowka.domain.test.UserCompletesTestUseCase;
import pl.edu.pjwstk.slowka.domain.test.UserStartsTestForCategoryUseCase;
import pl.edu.pjwstk.slowka.domain.test.UserUploadsCurrentTestImageAnswerUseCase;
import pl.edu.pjwstk.slowka.domain.test.UserViewNextTestImageUseCase;
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
    ViewAllPendingImageObjectsUseCase providesViewAllPendingImageObjectsUseCase(ImageObjectRepository imageObjectRepository) {
        return new ViewAllPendingImageObjectsUseCase(imageObjectRepository);
    }

    @Provides
    ViewKnownImageObjectsUseCase providesViewKnownImageObjectsUseCase(ImageObjectRepository imageObjectRepository) {
        return new ViewKnownImageObjectsUseCase(imageObjectRepository);
    }

    @Provides
    ViewAcceptedUnknownImageObjectsUseCase providesViewAcceptedUnknownImageObjectsUseCase(ImageObjectRepository imageObjectRepository) {
        return new ViewAcceptedUnknownImageObjectsUseCase(imageObjectRepository);
    }

    @Provides
    GetImageObjectUseCase providesGetImageObjectUseCase(ImageObjectRepository imageObjectRepository) {
        return new GetImageObjectUseCase(imageObjectRepository);
    }

    @Provides
    UpdateImageObjectUseCase providesUpdateImageObjectUseCase(ImageObjectRepository imageObjectRepository) {
        return new UpdateImageObjectUseCase(imageObjectRepository);
    }

    @Provides
    ViewAcceptedCategoryImagesObjectsUseCase providesViewAcceptedCategoryImageObjectsUseCase(ImageObjectRepository imageObjectRepository) {
        return new ViewAcceptedCategoryImagesObjectsUseCase(imageObjectRepository);
    }

    @Provides
    ViewAcceptedKnownCategoryImagesObjectsUseCase providesViewAcceptedKnownCategoryImagesObjectsUseCase(ImageObjectRepository imageObjectRepository) {
        return new ViewAcceptedKnownCategoryImagesObjectsUseCase(imageObjectRepository);
    }

    @Provides
    ViewAcceptedLearningCategoryImagesObjectsUseCase providesViewAcceptedLearningCategoryImagesObjectsUseCase(ImageObjectRepository imageObjectRepository) {
        return new ViewAcceptedLearningCategoryImagesObjectsUseCase(imageObjectRepository);
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

    @Provides
    CountAllImageObjectsWithCategoriesUseCase providesCountImageObjectsWithCategoriesUseCase(
            ViewAllImageObjectsUseCase viewAllImageObjectsUseCase,
            ViewAllCategoriesUseCase viewAllCategoriesUseCase
    ) {
        return new CountAllImageObjectsWithCategoriesUseCase(viewAllImageObjectsUseCase, viewAllCategoriesUseCase);
    }

    @Provides
    UserViewNextTestImageUseCase providesUserViewNextTestImageUseCase(TestRepository testRepository) {
        return new UserViewNextTestImageUseCase(testRepository);
    }

    @Provides
    UserUploadsCurrentTestImageAnswerUseCase providesUserUploadsCurrentTestImageAnswerUseCase(TestRepository testRepository) {
        return new UserUploadsCurrentTestImageAnswerUseCase(testRepository);
    }

    @Provides
    UserStartsTestForCategoryUseCase providesUserStartsTestForCategoryUseCase(TestRepository testRepository) {
        return new UserStartsTestForCategoryUseCase(testRepository);
    }

    @Provides
    UserCompletesTestUseCase providesUserCompletesTestUseCase(TestRepository testRepository) {
        return new UserCompletesTestUseCase(testRepository);
    }

    @Provides
    RestoreImageObjectToUnknownUseCase providesRestoreImageObjectToUnknownUseCase(
            ImageObjectRepository imageObjectRepository
    ) {
        return new RestoreImageObjectToUnknownUseCase(imageObjectRepository);
    }
}
