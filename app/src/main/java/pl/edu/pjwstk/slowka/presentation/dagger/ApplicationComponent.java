package pl.edu.pjwstk.slowka.presentation.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import pl.edu.pjwstk.slowka.domain.content.CountAllImageObjectsWithCategoriesUseCase;
import pl.edu.pjwstk.slowka.domain.content.GetImageObjectUseCase;
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
import pl.edu.pjwstk.slowka.domain.file.SaveBitmapUseCase;
import pl.edu.pjwstk.slowka.domain.file.SaveCameraFrameUseCase;
import pl.edu.pjwstk.slowka.domain.file.SaveCurrentCameraFrameUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.GetCurrentCameraFrameUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.LaunchCameraUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.PreviewCameraUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.StopCameraUseCase;
import pl.edu.pjwstk.slowka.domain.information.GetNamesForObjectInImageUseCase;
import pl.edu.pjwstk.slowka.domain.test.UserCompletesTestUseCase;
import pl.edu.pjwstk.slowka.domain.test.UserStartsTestForCategoryUseCase;
import pl.edu.pjwstk.slowka.domain.test.UserUploadsCurrentTestImageAnswerUseCase;
import pl.edu.pjwstk.slowka.domain.test.UserViewNextTestImageUseCase;
import pl.edu.pjwstk.slowka.presentation.speech.Speaker;

@Singleton
@Component(
        modules = {
                AndroidModule.class,
                RepositoriesModule.class,
                UsecasesModule.class,
                ServiceModule.class
        }
)
public interface ApplicationComponent {
    Context providesContext();
    Speaker providesSpeaker();

    StoreImageObjectUseCase providesStoreImageObjectUseCase();
    ViewAllImageObjectsUseCase providesViewAllImageObjectsUseCase();
    ViewAllPendingImageObjectsUseCase providesViewAllPendingImageObjectsUseCase();
    ViewKnownImageObjectsUseCase providesViewKnownImageObjectsUseCase();
    ViewAcceptedUnknownImageObjectsUseCase providesViewAcceptedUnknownImageObjectsUseCase();
    GetImageObjectUseCase providesGetImageObjectUseCase();
    UpdateImageObjectUseCase providesUpdateImageObjectUseCase();
    ViewAcceptedCategoryImagesObjectsUseCase providesViewAcceptedCategoryImageObjectsUseCase();
    ViewAcceptedKnownCategoryImagesObjectsUseCase providesViewAcceptedKnownCategoryImageObjectsUseCase();
    ViewAcceptedLearningCategoryImagesObjectsUseCase providesViewAcceptedLearningCategoryImageObjectsUseCase();
    SaveBitmapUseCase providesSaveBitmapUseCase();
    SaveCameraFrameUseCase providesSaveCameraFrameUseCase();
    SaveCurrentCameraFrameUseCase providesSaveCurrentCameraFrameUseCase();
    GetCurrentCameraFrameUseCase providesGetCurrentCameraFrameUseCase();
    LaunchCameraUseCase providesLaunchCameraUseCase();
    PreviewCameraUseCase providesPreviewCameraUseCase();
    StopCameraUseCase providesStopCameraUseCase();
    GetNamesForObjectInImageUseCase providesGetNamesForObjectInImageUseCase();
    ViewAllCategoriesUseCase providesViewAllCategoriesUseCase();
    StoreCategoryUseCase providesStoreCategoryUseCase();
    CountAllImageObjectsWithCategoriesUseCase providesCountImageObjectsWithCategoriesUseCase();
    UserViewNextTestImageUseCase providesUserViewNextTestImageUseCase();
    UserUploadsCurrentTestImageAnswerUseCase providesUserUploadsCurrentTestImageAnswerUseCase();
    UserStartsTestForCategoryUseCase providesUserStartsTestForCategoryUseCase();
    UserCompletesTestUseCase providesUserCompletesTestUseCase();
}
