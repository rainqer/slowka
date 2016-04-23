package pl.edu.pjwstk.slowka.presentation.ui.recognize.dagger;

import android.app.Application;

import pl.edu.pjwstk.slowka.presentation.dagger.Components;

public class RecognizeImageActivityComponentAssembler {

    private RecognizeImageActivityComponentAssembler() {
        throw new AssertionError("No instances.");
    }

    public static RecognizeImageActivityComponent assemble(Application application) {
        return DaggerRecognizeImageActivityComponent.builder()
                .applicationComponent(Components.from(application))
                .recognizeImageModule(new RecognizeImageModule())
                .build();
    }
}
