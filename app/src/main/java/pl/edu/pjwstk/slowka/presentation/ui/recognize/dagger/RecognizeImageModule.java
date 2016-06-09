package pl.edu.pjwstk.slowka.presentation.ui.recognize.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.content.StoreCategoryUseCase;
import pl.edu.pjwstk.slowka.domain.content.StoreImageObjectUseCase;
import pl.edu.pjwstk.slowka.domain.content.ViewAllCategoriesUseCase;
import pl.edu.pjwstk.slowka.domain.information.GetNamesForObjectInImageUseCase;
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageModel;

@Module
public class RecognizeImageModule {

    @RecognizeImageActivityScope
    @Provides
    RecognizeImageModel provideRecognizeImageModel(GetNamesForObjectInImageUseCase getNamesForObjectInImageUseCase,
                                                   StoreImageObjectUseCase storeImageObjectUseCase,
                                                   ViewAllCategoriesUseCase viewAllCategoriesUseCase,
                                                   StoreCategoryUseCase storeCategoryUseCase) {

        return new RecognizeImageModel(
                getNamesForObjectInImageUseCase,
                storeImageObjectUseCase,
                viewAllCategoriesUseCase,
                storeCategoryUseCase
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
