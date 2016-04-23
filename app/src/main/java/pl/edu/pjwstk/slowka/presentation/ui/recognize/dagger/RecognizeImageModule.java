package pl.edu.pjwstk.slowka.presentation.ui.recognize.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.StoreImageObjectUseCase;
import pl.edu.pjwstk.slowka.domain.information.GetNamesForObjectInImageUseCase;
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageModel;

@Module
public class RecognizeImageModule {

    @RecognizeImageActivityScope
    @Provides
    RecognizeImageModel provideRecognizeImageModel(GetNamesForObjectInImageUseCase getNamesForObjectInImageUseCase,
                                                   StoreImageObjectUseCase storeImageObjectUseCase) {

        return new RecognizeImageModel(
                getNamesForObjectInImageUseCase,
                storeImageObjectUseCase
        );
    }

    @RecognizeImageActivityScope
    @Provides
    RecognizeImageActivityPresenter provideRecognizeImageActivityPresenter(RecognizeImageModel recognizeImageActivityModel) {

        return new RecognizeImageActivityPresenter(
                recognizeImageActivityModel
        );
    }
}
