package pl.edu.pjwstk.presentation.dagger.recognize;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.presentation.model.recognize.RecognizeImageModel;
import pl.edu.pjwstk.presentation.presenter.recognize.RecognizeImageActivityPresenter;
import pl.edu.pjwstk.presentation.presenter.recognize.RecognizeImageActivityPresenterImpl;

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
