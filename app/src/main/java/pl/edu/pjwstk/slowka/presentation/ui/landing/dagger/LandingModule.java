package pl.edu.pjwstk.slowka.presentation.ui.landing.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.ViewAllCategoriesUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllImageObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllPendingImageObjectsUseCase;
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories.WordsCategoriesModel;
import pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories.WordsCategoriesPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.TutorFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_know.IKnowWordsListFragmentModel;
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
    ILearnWordsListFragmentModel provideILearnWordsListFragmentModel(ViewAllImageObjectsUseCase viewAllImageObjectsUseCase) {

        return new ILearnWordsListFragmentModel(viewAllImageObjectsUseCase);
    }

    @LandingActivityScope
    @Provides
    ILearnWordsListFragmentPresenter provideILearnWordsListFragmentPresenter(ILearnWordsListFragmentModel iLearnWordsListFragmentModel) {

        return new ILearnWordsListFragmentPresenter(iLearnWordsListFragmentModel);
    }

    @LandingActivityScope
    @Provides
    IKnowWordsListFragmentModel provideIKnowWordsListFragmentModel(ViewAllImageObjectsUseCase viewAllImageObjectsUseCase) {

        return new IKnowWordsListFragmentModel(viewAllImageObjectsUseCase);
    }

    @LandingActivityScope
    @Provides
    IKnowWordsListFragmentPresenter provideIKnowWordsListFragmentPresenter(IKnowWordsListFragmentModel iKnowWordsListFragmentModel) {

        return new IKnowWordsListFragmentPresenter(iKnowWordsListFragmentModel);
    }

    @LandingActivityScope
    @Provides
    NewWordsListFragmentModel provideNewWordsListFragmentModel(ViewAllPendingImageObjectsUseCase viewAllPendingImageObjectsUseCase) {

        return new NewWordsListFragmentModel(viewAllPendingImageObjectsUseCase);
    }

    @LandingActivityScope
    @Provides
    NewWordsListFragmentPresenter provideNewWordsListFragmentPresenter(NewWordsListFragmentModel newWordsListFragmentModel) {

        return new NewWordsListFragmentPresenter(newWordsListFragmentModel);
    }

    @LandingActivityScope
    @Provides
    WordsCategoriesPresenter provideWordsCategoriesPresenter(WordsCategoriesModel wordsCategoriesModel) {

        return new WordsCategoriesPresenter(wordsCategoriesModel);
    }

    @LandingActivityScope
    @Provides
    WordsCategoriesModel provideWordsCategoriesModel(ViewAllCategoriesUseCase viewAllCategoriesUseCase) {

        return new WordsCategoriesModel(viewAllCategoriesUseCase);
    }
}
