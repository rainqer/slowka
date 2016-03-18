package pl.edu.pjwstk.presentation.dagger.camera;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.presentation.model.camera.CameraActivityModel;
import pl.edu.pjwstk.presentation.presenter.camera.CameraActivityPresenter;
import pl.edu.pjwstk.presentation.presenter.camera.CameraActivityPresenterImpl;

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
