package pl.edu.pjwstk.presentation.dagger.recognize;

import dagger.Component;
import pl.edu.pjwstk.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.presentation.ui.recognize.RecognizeImageActivity;

@RecognizeImageActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = RecognizeImageModule.class
)
public interface RecognizeImageActivityComponent {
        void inject(RecognizeImageActivity activity);
}
