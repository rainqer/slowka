package pl.edu.pjwstk.slowka.presentation.ui.landing.dagger;

import dagger.Component;
import pl.edu.pjwstk.slowka.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivity;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_know.IKnowWordsListFragment;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_learn.ILearnWordsListFragment;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_new.NewWordsListFragment;
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.TutorFragment;

@LandingActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = LandingModule.class
)
public interface LandingActivityComponent {
        void inject(LandingActivity activity);
        void inject(TutorFragment fragment);
        void inject(ILearnWordsListFragment fragment);
        void inject(IKnowWordsListFragment fragment);
        void inject(NewWordsListFragment fragment);
}
