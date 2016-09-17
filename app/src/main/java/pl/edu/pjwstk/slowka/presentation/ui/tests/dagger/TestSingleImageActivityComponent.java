package pl.edu.pjwstk.slowka.presentation.ui.tests.dagger;

import dagger.Component;
import pl.edu.pjwstk.slowka.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.ui.tests.TestSingleImageActivity;

@TestSingleImageActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = TestSingleImageModule.class
)
public interface TestSingleImageActivityComponent {
        void inject(TestSingleImageActivity activity);
}
