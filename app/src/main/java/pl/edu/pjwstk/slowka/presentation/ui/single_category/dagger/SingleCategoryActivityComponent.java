package pl.edu.pjwstk.slowka.presentation.ui.single_category.dagger;

import dagger.Component;
import pl.edu.pjwstk.slowka.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivity;
import pl.edu.pjwstk.slowka.presentation.ui.landing.dagger.LandingActivityScope;
import pl.edu.pjwstk.slowka.presentation.ui.landing.dagger.LandingModule;
import pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories.WordsCategoriesListFragment;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.TutorFragment;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_know.IKnowWordsListFragment;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_learn.ILearnWordsListFragment;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_new.NewWordsListFragment;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivity;

@SingleCategoryActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = SingleCategoryModule.class
)
public interface SingleCategoryActivityComponent {
        void inject(SingleCategoryActivity activity);
}
