package pl.edu.pjwstk.slowka.presentation.dagger.landing;

import dagger.Component;
import pl.edu.pjwstk.slowka.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivity;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.IKnowWordsListFragment;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.ILearnWordsListFragment;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.NewWordsListFragment;

@LandingActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = LandingModule.class
)
public interface LandingActivityComponent {
        void inject(LandingActivity activity);
        void inject(ILearnWordsListFragment fragment);
        void inject(IKnowWordsListFragment fragment);
        void inject(NewWordsListFragment fragment);
}
