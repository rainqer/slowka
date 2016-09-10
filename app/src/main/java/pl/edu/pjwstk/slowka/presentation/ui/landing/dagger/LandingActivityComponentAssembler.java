package pl.edu.pjwstk.slowka.presentation.ui.landing.dagger;

import android.app.Application;
import pl.edu.pjwstk.slowka.presentation.dagger.Components;
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivity;

public class LandingActivityComponentAssembler {

    private LandingActivityComponentAssembler() {
        throw new AssertionError("No instances.");
    }

    public static LandingActivityComponent assemble(Application application, LandingActivity landingActivity) {
        return DaggerLandingActivityComponent.builder()
                .applicationComponent(Components.from(application))
                .landingModule(new LandingModule(landingActivity))
                .build();
    }
}
