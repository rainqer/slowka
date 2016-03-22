package pl.edu.pjwstk.slowka.presentation.dagger.camera;

import dagger.Component;
import pl.edu.pjwstk.slowka.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.presentation.ui.camera.CameraActivity;

@CameraActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = CameraModule.class
)
public interface CameraActivityComponent {
        void inject(CameraActivity activity);
}
