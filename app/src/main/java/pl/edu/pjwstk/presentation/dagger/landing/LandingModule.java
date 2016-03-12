package pl.edu.pjwstk.presentation.dagger.landing;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.presentation.presenter.landing.LandingActivityPresenter;
import pl.edu.pjwstk.presentation.presenter.landing.LandingActivityPresenterImpl;

@Module
public class LandingModule {

    @LandingActivityScope
    @Provides
    LandingActivityPresenter provideLandingActivityPresenter() {

        return new LandingActivityPresenterImpl();
    }
}
