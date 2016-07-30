package pl.edu.pjwstk.slowka.presentation.ui.single_category.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.ViewAcceptedCategoryImageObjectsUseCase;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryWordsListModel;

@Module
public class SingleCategoryModule {

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryActivityPresenter provideSingleCategoryActivityPresenter(
            SingleCategoryWordsListModel singleCategoryWordsListModel
    ) {
        return new SingleCategoryActivityPresenter(singleCategoryWordsListModel);
    }

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryWordsListModel provideSingleCategoryWordsListModel(
            ViewAcceptedCategoryImageObjectsUseCase viewAcceptedCategoryImageObjectsUseCase
    ) {
        return new SingleCategoryWordsListModel(viewAcceptedCategoryImageObjectsUseCase);
    }
}
