package pl.edu.pjwstk.presentation.dagger.camera;

import android.app.Application;

import pl.edu.pjwstk.presentation.dagger.Components;

public class CameraActivityComponentAssembler {

    private CameraActivityComponentAssembler() {
        throw new AssertionError("No instances.");
    }

    public static CameraActivityComponent assemble(Application application) {
        return DaggerCameraActivityComponent.builder()
                .applicationComponent(Components.from(application))
                .cameraModule(new CameraModule())
                .build();
    }
}
