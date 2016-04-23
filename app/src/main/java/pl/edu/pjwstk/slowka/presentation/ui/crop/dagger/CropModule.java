package pl.edu.pjwstk.slowka.presentation.ui.crop.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.file.SaveBitmapUseCase;
import pl.edu.pjwstk.slowka.presentation.ui.crop.CropActivityModel;
import pl.edu.pjwstk.slowka.presentation.ui.crop.CropImageActivityPresenter;

@Module
public class CropModule {

    @CropImageActivityScope
    @Provides
    CropActivityModel provideCropActivityModel(SaveBitmapUseCase saveBitmapUseCase) {

        return new CropActivityModel(saveBitmapUseCase);
    }

    @CropImageActivityScope
    @Provides
    CropImageActivityPresenter provideCroppImageActivityPresenter(CropActivityModel cropActivityModel) {

        return new CropImageActivityPresenter(cropActivityModel);
    }
}
