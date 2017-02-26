package pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.GetImageObjectUseCase;
import pl.edu.pjwstk.slowka.domain.content.RestoreImageObjectToUnknownUseCase;
import pl.edu.pjwstk.slowka.domain.content.StoreImageObjectUseCase;
import pl.edu.pjwstk.slowka.domain.content.UpdateImageObjectUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllCategoriesUseCase;
import pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.AdminImageDetailsActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.AdminImageDetailsModel;

@Module
public class AdminImageDetailsModule {

    @AdminImageDetailsActivityScope
    @Provides
    AdminImageDetailsModel provideRecognizeImageModel(
            UpdateImageObjectUseCase updateImageObjectUseCase,
            ViewAllCategoriesUseCase viewAllCategoriesUseCase,
            GetImageObjectUseCase getImageObjectUseCase,
            RestoreImageObjectToUnknownUseCase restoreImageObjectToUnknownUseCase) {

        return new AdminImageDetailsModel(
                updateImageObjectUseCase,
                viewAllCategoriesUseCase,
                getImageObjectUseCase,
                restoreImageObjectToUnknownUseCase
        );
    }

    @AdminImageDetailsActivityScope
    @Provides
    AdminImageDetailsActivityPresenter provideAdminImageDetailsActivityPresenter(
            AdminImageDetailsModel adminImageDetailsModel) {

        return new AdminImageDetailsActivityPresenter(
                adminImageDetailsModel
        );
    }
}
