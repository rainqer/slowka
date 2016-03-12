package pl.edu.pjwstk.presentation.dagger.camera;

import dagger.Component;
import pl.edu.pjwstk.presentation.dagger.ApplicationComponent;
import pl.edu.pjwstk.presentation.ui.camera.CameraActivity;

@CameraActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = CameraModule.class
)
public interface CameraActivityComponent {
        void inject(CameraActivity activity);
}
