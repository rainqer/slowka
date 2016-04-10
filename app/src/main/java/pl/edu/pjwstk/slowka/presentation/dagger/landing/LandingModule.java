package pl.edu.pjwstk.slowka.presentation.dagger.landing;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.LandingActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.LandingActivityPresenterImpl;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.ILearnWordsListFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.ILearnWordsListFragmentPresenterImpl;

@Module
public class LandingModule {

    @LandingActivityScope
    @Provides
    LandingActivityPresenter provideLandingActivityPresenter() {

        return new LandingActivityPresenterImpl();
    }

    @LandingActivityScope
    @Provides
    ILearnWordsListFragmentPresenter provideTutorWordsListFragmentPresenter() {

        return new ILearnWordsListFragmentPresenterImpl();
    }
}
