package pl.edu.pjwstk.slowka.presentation.ui.camera.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.file.SaveCurrentCameraFrameUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.LaunchCameraUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.PreviewCameraUseCase;
import pl.edu.pjwstk.slowka.domain.hardware.StopCameraUseCase;
import pl.edu.pjwstk.slowka.presentation.ui.camera.CameraActivityModel;
import pl.edu.pjwstk.slowka.presentation.ui.camera.CameraActivityPresenter;

@Module
public class CameraModule {

    @CameraActivityScope
    @Provides
    CameraActivityModel provideCameraActivityModel(LaunchCameraUseCase launchCameraUseCase,
                                                   StopCameraUseCase stopCameraUseCase,
                                                   PreviewCameraUseCase previewCameraUseCase,
                                                   SaveCurrentCameraFrameUseCase saveCurrentCameraFrameUseCase) {

        return new CameraActivityModel(
                launchCameraUseCase,
                stopCameraUseCase,
                previewCameraUseCase,
                saveCurrentCameraFrameUseCase
        );
    }

    @CameraActivityScope
    @Provides
    CameraActivityPresenter provideCameraActivityPresenter(CameraActivityModel cameraActivityModel) {

        return new CameraActivityPresenter(
                cameraActivityModel
        );
    }

}
