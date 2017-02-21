package pl.edu.pjwstk.slowka.presentation.ui.single_category.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedCategoryImageObjectsUseCase;
import pl.edu.pjwstk.slowka.presentation.speech.Speaker;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivity;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.SingleCategoryListOfWordsAdapter;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.known.SingleCategoryKnownWordsFragmentModel;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.known.SingleCategoryKnownWordsFragmentPresenter;

@Module
class SingleCategoryModule {

    private SingleCategoryActivity singleCategoryActivity;

    SingleCategoryModule(SingleCategoryActivity singleCategoryActivity) {
        this.singleCategoryActivity = singleCategoryActivity;
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryActivityPresenter provideSingleCategoryActivityPresenter(
            SingleCategoryListOfWordsAdapter singleCategoryListOfWordsAdapter
    ) {
        return new SingleCategoryActivityPresenter(singleCategoryListOfWordsAdapter);
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryListOfWordsAdapter providesSingleCategoryListOfWordsAdapter(Speaker speaker) {
        return new SingleCategoryListOfWordsAdapter(singleCategoryActivity, speaker);
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryKnownWordsFragmentModel providesSingleCategoryKnownWordsFragmentModel(
            ViewAcceptedCategoryImageObjectsUseCase viewAcceptedCategoryImageObjectsUseCase) {
        return new SingleCategoryKnownWordsFragmentModel(viewAcceptedCategoryImageObjectsUseCase);
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryKnownWordsFragmentPresenter providesSingleCategoryKnownWordsFragmentPresenter(
            SingleCategoryKnownWordsFragmentModel singleCategoryKnownWordsFragmentModel,
            SingleCategoryListOfWordsAdapter singleCategoryListOfWordsAdapter) {
        return new SingleCategoryKnownWordsFragmentPresenter(singleCategoryKnownWordsFragmentModel, singleCategoryListOfWordsAdapter);
    }
}
