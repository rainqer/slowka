package pl.edu.pjwstk.slowka.dagger.camera;

import dagger.Component;
import pl.edu.pjwstk.slowka.dagger.ApplicationComponent;
import pl.edu.pjwstk.slowka.ui.camera.CameraActivity;

@CameraActivityScope
@Component (
        dependencies = ApplicationComponent.class,
        modules = CameraModule.class
)
public interface CameraActivityComponent {
        void inject(CameraActivity activity);
}
