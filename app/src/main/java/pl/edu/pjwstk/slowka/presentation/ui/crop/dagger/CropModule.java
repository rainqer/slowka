package pl.edu.pjwstk.slowka.presentation.ui.crop.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.ui.crop.CropActivityModel;
import pl.edu.pjwstk.slowka.presentation.ui.crop.CropImageActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.crop.CropImageActivityPresenterImpl;

@Module
public class CropModule {

    @CropImageActivityScope
    @Provides
    CropImageActivityPresenter provideCroppImageActivityPresenter(CropActivityModel cropActivityModel) {

        return new CropImageActivityPresenterImpl(cropActivityModel);
    }
}
