package pl.edu.pjwstk.slowka.presentation.dagger.landing;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.LandingActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.LandingActivityPresenterImpl;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.TutorWordsListFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.TutorWordsListFragmentPresenterImpl;
import pl.edu.pjwstk.slowka.presentation.ui.landing.TutorWordsListFragment;

@Module
public class LandingModule {

    @LandingActivityScope
    @Provides
    LandingActivityPresenter provideLandingActivityPresenter(TutorWordsListFragment tutorWordsListFragment) {

        return new LandingActivityPresenterImpl(tutorWordsListFragment);
    }

    @LandingActivityScope
    @Provides
    TutorWordsListFragmentPresenter provideTutorWordsListFragmentPresenter() {

        return new TutorWordsListFragmentPresenterImpl();
    }
}
