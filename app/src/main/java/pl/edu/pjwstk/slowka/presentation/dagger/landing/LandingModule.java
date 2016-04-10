package pl.edu.pjwstk.slowka.presentation.dagger.landing;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.LandingActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.LandingActivityPresenterImpl;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor.IKnowWordsListFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor.ILearnWordsListFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor.NewWordsListFragmentPresenter;

@Module
public class LandingModule {

    @LandingActivityScope
    @Provides
    LandingActivityPresenter provideLandingActivityPresenter() {

        return new LandingActivityPresenterImpl();
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
