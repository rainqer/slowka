package pl.edu.pjwstk.slowka.presentation.ui.single_category.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedCategoryImagesObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedKnownCategoryImagesObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedLearningCategoryImagesObjectsUseCase;
import pl.edu.pjwstk.slowka.presentation.speech.Speaker;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivity;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.SingleCategoryListOfWordsAdapter;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.all.SingleCategoryAcceptedWordsFragmentModel;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.all.SingleCategoryAcceptedWordsFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.known.SingleCategoryKnownWordsFragmentModel;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.known.SingleCategoryKnownWordsFragmentPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.learning.SingleCategoryLearningWordsFragmentModel;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.learning.SingleCategoryLearningWordsFragmentPresenter;

@Module
class SingleCategoryModule {

    private SingleCategoryActivity singleCategoryActivity;

    SingleCategoryModule(SingleCategoryActivity singleCategoryActivity) {
        this.singleCategoryActivity = singleCategoryActivity;
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryActivityPresenter provideSingleCategoryActivityPresenter() {
        return new SingleCategoryActivityPresenter();
    }

    @Provides
    SingleCategoryListOfWordsAdapter providesSingleCategoryListOfWordsAdapter(Speaker speaker) {
        return new SingleCategoryListOfWordsAdapter(singleCategoryActivity, speaker);
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryKnownWordsFragmentModel providesSingleCategoryKnownWordsFragmentModel(
            ViewAcceptedKnownCategoryImagesObjectsUseCase viewAcceptedKnownCategoryImagesObjectsUseCase) {
        return new SingleCategoryKnownWordsFragmentModel(viewAcceptedKnownCategoryImagesObjectsUseCase);
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryKnownWordsFragmentPresenter providesSingleCategoryKnownWordsFragmentPresenter(
            SingleCategoryKnownWordsFragmentModel singleCategoryKnownWordsFragmentModel,
            SingleCategoryListOfWordsAdapter singleCategoryListOfWordsAdapter) {
        return new SingleCategoryKnownWordsFragmentPresenter(singleCategoryKnownWordsFragmentModel, singleCategoryListOfWordsAdapter);
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryLearningWordsFragmentModel providesSingleCategoryLearningWordsFragmentModel(
            ViewAcceptedLearningCategoryImagesObjectsUseCase viewAcceptedLearningCategoryImagesObjectsUseCase) {
        return new SingleCategoryLearningWordsFragmentModel(viewAcceptedLearningCategoryImagesObjectsUseCase);
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryLearningWordsFragmentPresenter providesSingleCategoryLearningWordsFragmentPresenter(
            SingleCategoryLearningWordsFragmentModel singleCategoryLearningWordsFragmentModel,
            SingleCategoryListOfWordsAdapter singleCategoryListOfWordsAdapter) {
        return new SingleCategoryLearningWordsFragmentPresenter(singleCategoryLearningWordsFragmentModel, singleCategoryListOfWordsAdapter);
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryAcceptedWordsFragmentModel providesSingleCategoryAcceptedWordsFragmentModel(
            ViewAcceptedCategoryImagesObjectsUseCase viewAcceptedAcceptedCategoryImagesObjectsUseCase) {
        return new SingleCategoryAcceptedWordsFragmentModel(viewAcceptedAcceptedCategoryImagesObjectsUseCase);
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryAcceptedWordsFragmentPresenter providesSingleCategoryAcceptedWordsFragmentPresenter(
            SingleCategoryAcceptedWordsFragmentModel singleCategoryAcceptedWordsFragmentModel,
            SingleCategoryListOfWordsAdapter singleCategoryListOfWordsAdapter) {
        return new SingleCategoryAcceptedWordsFragmentPresenter(singleCategoryAcceptedWordsFragmentModel, singleCategoryListOfWordsAdapter);
    }
}
