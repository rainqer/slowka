package pl.edu.pjwstk.slowka.presentation.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import pl.edu.pjwstk.slowka.domain.content.StoreCategoryUseCase;
import pl.edu.pjwstk.slowka.domain.content.StoreImageObjectUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllCategoriesUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllImageObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.file.SaveBitmapUseCase;
import pl.edu.pjwstk.slowka.domain.file.SaveCameraFrameUseCase;
import pl.edu.pjwstk.slowka.domain.file.SaveCurrentCameraFrameUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.GetCurrentCameraFrameUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.LaunchCameraUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.PreviewCameraUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.StopCameraUseCase;
import pl.edu.pjwstk.slowka.domain.information.GetNamesForObjectInImageUseCase;

@Singleton
@Component(
        modules = {
                AndroidModule.class,
                RepositoriesModule.class,
                UsecasesModule.class
        }
)
public interface ApplicationComponent {
    Context providesContext();

    StoreImageObjectUseCase providesStoreImageObjectUseCase();
    ViewAllImageObjectsUseCase providesViewAllImageObjectsUseCase();
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
}
