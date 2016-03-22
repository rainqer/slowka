package pl.edu.pjwstk.slowka.presentation.dagger.recognize;

import dagger.Component;
import pl.edu.pjwstk.slowka.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivity;

@RecognizeImageActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = RecognizeImageModule.class
)
public interface RecognizeImageActivityComponent {
        void inject(RecognizeImageActivity activity);
}
