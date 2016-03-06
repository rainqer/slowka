package pl.edu.pjwstk.slowka.dagger.landing;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presenter.landing.LandingActivityPresenter;
import pl.edu.pjwstk.slowka.presenter.landing.LandingActivityPresenterImpl;

@Module
public class LandingModule {

    @LandingActivityScope
    @Provides
    LandingActivityPresenter provideLandingActivityPresenter() {

        return new LandingActivityPresenterImpl();
    }
}
