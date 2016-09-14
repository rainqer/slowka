package pl.edu.pjwstk.slowka.presentation.ui.landing.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.CountImageObjectsWithCategoriesUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllImageObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllPendingImageObjectsUseCase;
import pl.edu.pjwstk.slowka.presentation.speech.Speaker;
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivity;
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.TutorListOfWordsAdapter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories.WordsCategoriesModel;
import pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories.WordsCategoriesPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tests.SelectTestsModel;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tests.SelectTestsFragmentPresenter;
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
    ILearnWordsListFragmentModel provideILearnWordsListFragmentModel(ViewAllImageObjectsUseCase viewAllImageObjectsUseCase) {

        return new ILearnWordsListFragmentModel(viewAllImageObjectsUseCase);
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
    IKnowWordsListFragmentModel provideIKnowWordsListFragmentModel(ViewAllImageObjectsUseCase viewAllImageObjectsUseCase) {

        return new IKnowWordsListFragmentModel(viewAllImageObjectsUseCase);
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
    NewWordsListFragmentModel provideNewWordsListFragmentModel(ViewAllPendingImageObjectsUseCase viewAllPendingImageObjectsUseCase) {

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
    WordsCategoriesModel provideWordsCategoriesModel(CountImageObjectsWithCategoriesUseCase countImageObjectsWithCategoriesUseCase) {

        return new WordsCategoriesModel(countImageObjectsWithCategoriesUseCase);
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
    SelectTestsModel providesAvailableTestsModel(CountImageObjectsWithCategoriesUseCase countImageObjectsWithCategoriesUseCase) {
        return new SelectTestsModel(countImageObjectsWithCategoriesUseCase);
    }

}
