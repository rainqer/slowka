package pl.edu.pjwstk.slowka.presentation.dagger.cropp;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.file.SaveBitmapUseCase;
import pl.edu.pjwstk.slowka.presentation.model.crop.CropActivityModel;
import pl.edu.pjwstk.slowka.presentation.presenter.cropp.CropImageActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.cropp.CropImageActivityPresenterImpl;

@Module
public class CropModule {

    @CropImageActivityScope
    @Provides
    CropImageActivityPresenter provideCroppImageActivityPresenter(CropActivityModel cropActivityModel) {

        return new CropImageActivityPresenterImpl(cropActivityModel);
    }
}
