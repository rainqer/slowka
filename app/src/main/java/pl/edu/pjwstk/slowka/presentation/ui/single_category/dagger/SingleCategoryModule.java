package pl.edu.pjwstk.slowka.presentation.ui.single_category.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedCategoryConvertedImageObjectsUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedCategoryImageObjectsUseCase;
import pl.edu.pjwstk.slowka.presentation.speech.Speaker;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivity;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryListOfWordsAdapter;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryWordsListModel;

@Module
class SingleCategoryModule {

    private SingleCategoryActivity singleCategoryActivity;

    SingleCategoryModule(SingleCategoryActivity singleCategoryActivity) {
        this.singleCategoryActivity = singleCategoryActivity;
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryActivityPresenter provideSingleCategoryActivityPresenter(
            SingleCategoryWordsListModel singleCategoryWordsListModel,
            SingleCategoryListOfWordsAdapter singleCategoryListOfWordsAdapter
    ) {
        return new SingleCategoryActivityPresenter(singleCategoryWordsListModel, singleCategoryListOfWordsAdapter);
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryListOfWordsAdapter providesSingleCategoryListOfWordsAdapter(Speaker speaker) {
        return new SingleCategoryListOfWordsAdapter(singleCategoryActivity, speaker);
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryWordsListModel provideSingleCategoryWordsListModel(
            ViewAcceptedCategoryConvertedImageObjectsUseCase viewAcceptedCategoryConvertedImageObjectsUseCase
    ) {
        return new SingleCategoryWordsListModel(viewAcceptedCategoryConvertedImageObjectsUseCase);
    }
}
