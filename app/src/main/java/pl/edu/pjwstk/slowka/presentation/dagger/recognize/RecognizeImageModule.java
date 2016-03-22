package pl.edu.pjwstk.slowka.presentation.dagger.recognize;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.presentation.model.recognize.RecognizeImageModel;
import pl.edu.pjwstk.slowka.presentation.presenter.recognize.RecognizeImageActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.presenter.recognize.RecognizeImageActivityPresenterImpl;

@Module
public class RecognizeImageModule {

    @RecognizeImageActivityScope
    @Provides
    RecognizeImageActivityPresenter provideRecognizeImageActivityPresenter(RecognizeImageModel recognizeImageActivityModel) {

        return new RecognizeImageActivityPresenterImpl(
                recognizeImageActivityModel
        );
    }
}
