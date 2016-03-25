package pl.edu.pjwstk.slowka.presentation.dagger.cropp;

import dagger.Component;
import pl.edu.pjwstk.slowka.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.ui.cropp.CroppImageActivity;

@CroppImageActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = CroppModule.class
)
public interface CroppImageActivityComponent {
        void inject(CroppImageActivity activity);
}
