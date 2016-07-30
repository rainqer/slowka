package pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.dagger;

import android.app.Application;

import pl.edu.pjwstk.slowka.presentation.dagger.Components;
import pl.edu.pjwstk.slowka.presentation.ui.recognize.dagger.DaggerRecognizeImageActivityComponent;

public class AdminImageDetailsActivityComponentAssembler {

    private AdminImageDetailsActivityComponentAssembler() {
        throw new AssertionError("No instances.");
    }

    public static AdminImageDetailsActivityComponent assemble(Application application) {
        return DaggerAdminImageDetailsActivityComponent.builder()
                .applicationComponent(Components.from(application))
                .adminImageDetailsModule(new AdminImageDetailsModule())
                .build();
    }
}
