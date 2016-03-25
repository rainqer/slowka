package pl.edu.pjwstk.slowka.presentation.dagger.cropp;

import dagger.Component;
import pl.edu.pjwstk.slowka.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.ui.cropp.CropImageActivity;

@CropImageActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = CropModule.class
)
public interface CropImageActivityComponent {
        void inject(CropImageActivity activity);
}
