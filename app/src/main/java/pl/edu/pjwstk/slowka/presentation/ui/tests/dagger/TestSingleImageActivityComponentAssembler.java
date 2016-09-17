package pl.edu.pjwstk.slowka.presentation.ui.tests.dagger;

import android.app.Application;

import pl.edu.pjwstk.slowka.presentation.dagger.Components;

public class TestSingleImageActivityComponentAssembler {

    private TestSingleImageActivityComponentAssembler() {
        throw new AssertionError("No instances.");
    }

    public static TestSingleImageActivityComponent assemble(Application application) {
        return DaggerTestSingleImageActivityComponent.builder()
                .applicationComponent(Components.from(application))
                .testSingleImageModule(new TestSingleImageModule())
                .build();
    }
}
