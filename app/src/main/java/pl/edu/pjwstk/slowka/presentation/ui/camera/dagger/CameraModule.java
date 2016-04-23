package pl.edu.pjwstk.slowka.presentation.ui.camera.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.ui.camera.CameraActivityModel;
import pl.edu.pjwstk.slowka.presentation.ui.camera.CameraActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.camera.CameraActivityPresenterImpl;

@Module
public class CameraModule {

    @CameraActivityScope
    @Provides
    CameraActivityPresenter provideCameraActivityPresenter(CameraActivityModel cameraActivityModel) {

        return new CameraActivityPresenterImpl(
                cameraActivityModel
        );
    }

}
