package pl.edu.pjwstk.slowka.presentation.ui.crop.dagger;

import dagger.Component;
import pl.edu.pjwstk.slowka.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.ui.crop.CropImageActivity;

@CropImageActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = CropModule.class
)
public interface CropImageActivityComponent {
        void inject(CropImageActivity activity);
}
