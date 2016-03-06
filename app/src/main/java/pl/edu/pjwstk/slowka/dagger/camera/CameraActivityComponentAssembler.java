package pl.edu.pjwstk.slowka.dagger.camera;

import android.app.Application;

import pl.edu.pjwstk.slowka.dagger.Components;

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
