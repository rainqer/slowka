package pl.edu.pjwstk.slowka.presentation.dagger.cropp;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.presenter.cropp.CroppImageActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.cropp.CroppImageActivityPresenterImpl;

@Module
public class CroppModule {

    @CroppImageActivityScope
    @Provides
    CroppImageActivityPresenter provideCroppImageActivityPresenter() {

        return new CroppImageActivityPresenterImpl();
    }
}
