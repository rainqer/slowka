package pl.edu.pjwstk.slowka.presentation.ui.landing.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_know.IKnowWordsListFragmentModel;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.TutorFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_know.IKnowWordsListFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_learn.ILearnWordsListFragmentModel;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_learn.ILearnWordsListFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_new.NewWordsListFragmentModel;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_new.NewWordsListFragmentPresenter;

@Module
public class LandingModule {

    @LandingActivityScope
    @Provides
    LandingActivityPresenter provideLandingActivityPresenter() {

        return new LandingActivityPresenter();
    }

    @LandingActivityScope
    @Provides
    TutorFragmentPresenter provideTutorFragmentPresenter() {

        return new TutorFragmentPresenter();
    }

    @LandingActivityScope
    @Provides
    ILearnWordsListFragmentPresenter provideILearnWordsListFragmentPresenter(ILearnWordsListFragmentModel iLearnWordsListFragmentModel) {

        return new ILearnWordsListFragmentPresenter(iLearnWordsListFragmentModel);
    }

    @LandingActivityScope
    @Provides
    IKnowWordsListFragmentPresenter provideIKnowWordsListFragmentPresenter(IKnowWordsListFragmentModel iKnowWordsListFragmentModel) {

        return new IKnowWordsListFragmentPresenter(iKnowWordsListFragmentModel);
    }

    @LandingActivityScope
    @Provides
    NewWordsListFragmentPresenter provideNewWordsListFragmentPresenter(NewWordsListFragmentModel newWordsListFragmentModel) {

        return new NewWordsListFragmentPresenter(newWordsListFragmentModel);
    }
}
