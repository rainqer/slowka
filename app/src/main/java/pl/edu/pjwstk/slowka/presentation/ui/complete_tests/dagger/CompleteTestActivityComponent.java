package pl.edu.pjwstk.slowka.presentation.ui.complete_tests.dagger;

import dagger.Component;
import pl.edu.pjwstk.slowka.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.ui.complete_tests.CompleteTestActivity;

@CompleteTestActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = CompleteTestModule.class
)
public interface CompleteTestActivityComponent {
        void inject(CompleteTestActivity activity);
}
