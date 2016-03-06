package pl.edu.pjwstk.slowka.dagger.camera;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.model.camera.CameraActivityModel;
import pl.edu.pjwstk.slowka.model.camera.CameraAdapter;
import pl.edu.pjwstk.slowka.presenter.camera.CameraActivityPresenter;
import pl.edu.pjwstk.slowka.presenter.camera.CameraActivityPresenterImpl;

@Module
public class CameraModule {

    @CameraActivityScope
    @Provides
    CameraActivityPresenter provideCameraActivityPresenter(CameraActivityModel cameraActivityModel) {

        return new CameraActivityPresenterImpl(
                cameraActivityModel
        );
    }

    @CameraActivityScope
    @Provides
    CameraActivityModel provideCameraActivityModel(CameraAdapter cameraAdapter) {

        return new CameraActivityModel(
                cameraAdapter
        );
    }

    @CameraActivityScope
    @Provides
    CameraAdapter provideCameraAdapter() {

        return new CameraAdapter();
    }
}
