package pl.edu.pjwstk.slowka.presentation.dagger.camera;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.model.camera.CameraActivityModel;
import pl.edu.pjwstk.slowka.presentation.presenter.camera.CameraActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.camera.CameraActivityPresenterImpl;

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
