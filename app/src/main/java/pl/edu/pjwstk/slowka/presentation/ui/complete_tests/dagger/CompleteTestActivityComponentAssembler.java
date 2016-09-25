package pl.edu.pjwstk.slowka.presentation.ui.complete_tests.dagger;

import android.app.Application;

import pl.edu.pjwstk.slowka.presentation.dagger.Components;
import pl.edu.pjwstk.slowka.presentation.ui.tests.dagger.DaggerTestSingleImageActivityComponent;

public class CompleteTestActivityComponentAssembler {

    private CompleteTestActivityComponentAssembler() {
        throw new AssertionError("No instances.");
    }

    public static CompleteTestActivityComponent assemble(Application application) {
        return DaggerCompleteTestActivityComponent.builder()
                .applicationComponent(Components.from(application))
                .completeTestModule(new CompleteTestModule())
                .build();
    }
}
