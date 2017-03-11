package pl.edu.pjwstk.slowka.presentation.ui.crop.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.StoreImageObjectUseCase;
import pl.edu.pjwstk.slowka.domain.file.SaveBitmapUseCase;
import pl.edu.pjwstk.slowka.domain.information.GetNamesForObjectInImageUseCase;
import pl.edu.pjwstk.slowka.presentation.ui.crop.CropActivityModel;
import pl.edu.pjwstk.slowka.presentation.ui.crop.CropImageActivityPresenter;

@Module
public class CropModule {

    @CropImageActivityScope
    @Provides
    CropActivityModel provideCropActivityModel(SaveBitmapUseCase saveBitmapUseCase,
                                               GetNamesForObjectInImageUseCase getNamesForObjectInImageUseCase,
                                               StoreImageObjectUseCase storeImageObjectUseCase) {

        return new CropActivityModel(saveBitmapUseCase, getNamesForObjectInImageUseCase, storeImageObjectUseCase);
    }

    @CropImageActivityScope
    @Provides
    CropImageActivityPresenter provideCroppImageActivityPresenter(CropActivityModel cropActivityModel) {

        return new CropImageActivityPresenter(cropActivityModel);
    }
}
