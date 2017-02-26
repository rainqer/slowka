package pl.edu.pjwstk.slowka.presentation.ui.landing.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.CountAllImageObjectsWithCategoriesUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedUnknownImageObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllPendingImageObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewKnownImageObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.test.UserStartsTestForCategoryUseCase;
import pl.edu.pjwstk.slowka.presentation.speech.Speaker;
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivity;
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.TutorListOfWordsAdapter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories.WordsCategoriesModel;
import pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories.WordsCategoriesPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tests.SelectTestsFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tests.SelectTestsModel;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.TutorFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_know.IKnowWordsListFragmentModel;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_know.IKnowWordsListFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_learn.ILearnWordsListFragmentModel;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_learn.ILearnWordsListFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_new.NewWordsListFragmentModel;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_new.NewWordsListFragmentPresenter;

@Module
public class LandingModule {

    private LandingActivity landingActivity;

    public LandingModule(LandingActivity landingActivity) {
        this.landingActivity = landingActivity;
    }

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
    ILearnWordsListFragmentModel provideILearnWordsListFragmentModel(
            ViewAcceptedUnknownImageObjectsUseCase viewAcceptedUnknownImageObjectsUseCase) {

        return new ILearnWordsListFragmentModel(viewAcceptedUnknownImageObjectsUseCase);
    }

    @LandingActivityScope
    @Provides
    ILearnWordsListFragmentPresenter provideILearnWordsListFragmentPresenter(
            ILearnWordsListFragmentModel iLearnWordsListFragmentModel,
            TutorListOfWordsAdapter tutorListOfWordsAdapter) {

        return new ILearnWordsListFragmentPresenter(iLearnWordsListFragmentModel, tutorListOfWordsAdapter);
    }

    @LandingActivityScope
    @Provides
    IKnowWordsListFragmentModel provideIKnowWordsListFragmentModel(
            ViewKnownImageObjectsUseCase viewKnownImageObjectsUseCase) {

        return new IKnowWordsListFragmentModel(viewKnownImageObjectsUseCase);
    }

    @LandingActivityScope
    @Provides
    IKnowWordsListFragmentPresenter provideIKnowWordsListFragmentPresenter(
            IKnowWordsListFragmentModel iKnowWordsListFragmentModel,
            TutorListOfWordsAdapter tutorListOfWordsAdapter) {

        return new IKnowWordsListFragmentPresenter(iKnowWordsListFragmentModel, tutorListOfWordsAdapter);
    }

    @LandingActivityScope
    @Provides
    NewWordsListFragmentModel provideNewWordsListFragmentModel(
            ViewAllPendingImageObjectsUseCase viewAllPendingImageObjectsUseCase) {

        return new NewWordsListFragmentModel(viewAllPendingImageObjectsUseCase);
    }

    @LandingActivityScope
    @Provides
    NewWordsListFragmentPresenter provideNewWordsListFragmentPresenter(
            NewWordsListFragmentModel newWordsListFragmentModel,
            TutorListOfWordsAdapter tutorListOfWordsAdapter) {

        return new NewWordsListFragmentPresenter(newWordsListFragmentModel, tutorListOfWordsAdapter);
    }

    @LandingActivityScope
    @Provides
    WordsCategoriesPresenter provideWordsCategoriesPresenter(WordsCategoriesModel wordsCategoriesModel) {

        return new WordsCategoriesPresenter(wordsCategoriesModel);
    }

    @LandingActivityScope
    @Provides
    WordsCategoriesModel provideWordsCategoriesModel(CountAllImageObjectsWithCategoriesUseCase countAllImageObjectsWithCategoriesUseCase) {

        return new WordsCategoriesModel(countAllImageObjectsWithCategoriesUseCase);
    }

    @Provides
    TutorListOfWordsAdapter providesTutorListOfWordsAdapter(Speaker speaker) {
        return new TutorListOfWordsAdapter(landingActivity, speaker);
    }

    @LandingActivityScope
    @Provides
    SelectTestsFragmentPresenter providesSelectTestsFragmentPresenter(SelectTestsModel selectTestsModel) {
        return new SelectTestsFragmentPresenter(selectTestsModel);
    }

    @LandingActivityScope
    @Provides
    SelectTestsModel providesAvailableTestsModel(CountAllImageObjectsWithCategoriesUseCase countAllImageObjectsWithCategoriesUseCase,
                                                 UserStartsTestForCategoryUseCase userStartsTestForCategoryUseCase) {
        return new SelectTestsModel(
                countAllImageObjectsWithCategoriesUseCase,
                userStartsTestForCategoryUseCase
        );
    }
}
