package pl.edu.pjwstk.slowka.presentation.ui.crop.dagger;

import android.app.Application;

import pl.edu.pjwstk.slowka.presentation.dagger.Components;

public class CropImageActivityComponentAssembler {

    private CropImageActivityComponentAssembler() {
        throw new AssertionError("No instances.");
    }

    public static CropImageActivityComponent assemble(Application application) {
        return DaggerCropImageActivityComponent.builder()
                .applicationComponent(Components.from(application))
                .build();
    }
}
