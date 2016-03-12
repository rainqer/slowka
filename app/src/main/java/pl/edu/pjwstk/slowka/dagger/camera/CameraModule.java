package pl.edu.pjwstk.slowka.dagger.camera;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.model.camera.CameraActivityModel;
import pl.edu.pjwstk.slowka.presenter.camera.CameraActivityPresenter;
import pl.edu.pjwstk.slowka.presenter.camera.CameraActivityPresenterImpl;
import pl.rhinoonabus.slowka.hardware.LaunchCameraUseCase;

@Module
public class CameraModule {

    @CameraActivityScope
    @Provides
    CameraActivityPresenter provideCameraActivityPresenter(CameraActivityModel cameraActivityModel) {

        return new CameraActivityPresenterImpl(
                cameraActivityModel
        );
    }
//
//    @CameraActivityScope
//    @Provides
//    CameraActivityModel provideCameraActivityModel(LaunchCameraUseCase launchCameraUseCase) {
//
//        return new CameraActivityModel(
//                launchCameraUseCase
//        );
//    }

//    @CameraActivityScope
//    @Provides
//    CameraAdapter provideCameraAdapter() {
//
//        return new CameraAdapter();
//    }
//
//    @CameraActivityScope
//    @Provides
//    LaunchCameraUseCase provideLaunchCameraUseCase(CameraRepository cameraRepository) {
//
//        return new LaunchCameraUseCase(cameraRepository);
//    }
}
