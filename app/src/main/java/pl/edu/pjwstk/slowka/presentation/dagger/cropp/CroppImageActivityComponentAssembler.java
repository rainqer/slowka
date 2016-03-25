package pl.edu.pjwstk.slowka.presentation.dagger.cropp;

import android.app.Application;

import pl.edu.pjwstk.slowka.presentation.dagger.Components;

public class CroppImageActivityComponentAssembler {

    private CroppImageActivityComponentAssembler() {
        throw new AssertionError("No instances.");
    }

    public static CroppImageActivityComponent assemble(Application application) {
        return DaggerCroppImageActivityComponent.builder()
                .applicationComponent(Components.from(application))
                .build();
    }
}
