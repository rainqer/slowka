package pl.edu.pjwstk.slowka.presentation.dagger.landing;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.LandingActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.LandingActivityPresenterImpl;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor.IKnowWordsListFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor.ILearnWordsListFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor.NewWordsListFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor.TutorFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor.TutorFragmentPresenterImpl;

@Module
public class LandingModule {

    @LandingActivityScope
    @Provides
    LandingActivityPresenter provideLandingActivityPresenter() {

        return new LandingActivityPresenterImpl();
    }

    @LandingActivityScope
    @Provides
    TutorFragmentPresenter provideTutorFragmentPresenter() {

        return new TutorFragmentPresenterImpl();
    }

    @LandingActivityScope
    @Provides
    ILearnWordsListFragmentPresenter provideILearnWordsListFragmentPresenter() {

        return new ILearnWordsListFragmentPresenter();
    }

    @LandingActivityScope
    @Provides
    IKnowWordsListFragmentPresenter provideIKnowWordsListFragmentPresenter() {

        return new IKnowWordsListFragmentPresenter();
    }

    @LandingActivityScope
    @Provides
    NewWordsListFragmentPresenter provideNewWordsListFragmentPresenter() {

        return new NewWordsListFragmentPresenter();
    }
}
