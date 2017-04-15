package pl.edu.pjwstk.slowka.presentation.ui.single_category.dagger;

import dagger.Component;
import pl.edu.pjwstk.slowka.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivity;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.all.SingleCategoryAcceptedWordsFragment;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.known.SingleCategoryKnownWordsFragment;
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.learning.SingleCategoryLearningWordsFragment;

@SingleCategoryActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = SingleCategoryModule.class
)
public interface SingleCategoryActivityComponent {
        void inject(SingleCategoryActivity activity);
        void inject(SingleCategoryKnownWordsFragment fragment);
        void inject(SingleCategoryLearningWordsFragment fragment);
        void inject(SingleCategoryAcceptedWordsFragment fragment);
}
