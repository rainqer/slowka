package pl.edu.pjwstk.slowka.presentation.ui.recognize.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageModel;

@Module
public class RecognizeImageModule {

    @RecognizeImageActivityScope
    @Provides
    RecognizeImageActivityPresenter provideRecognizeImageActivityPresenter(RecognizeImageModel recognizeImageActivityModel) {

        return new RecognizeImageActivityPresenter(
                recognizeImageActivityModel
        );
    }
}
