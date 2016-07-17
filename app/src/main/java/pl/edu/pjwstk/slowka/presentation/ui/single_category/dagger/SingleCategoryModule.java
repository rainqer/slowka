package pl.edu.pjwstk.slowka.presentation.ui.single_category.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivityPresenter;

@Module
public class SingleCategoryModule {

    @SingleCategoryActivityScope
    @Provides
    SingleCategoryActivityPresenter provideSingleCategoryActivityPresenter() {

        return new SingleCategoryActivityPresenter();
    }
}
