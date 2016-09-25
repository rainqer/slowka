package pl.edu.pjwstk.slowka.presentation.ui.complete_tests.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.test.UserCompletesTestUseCase;
import pl.edu.pjwstk.slowka.presentation.ui.complete_tests.CompleteTestActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.complete_tests.CompleteTestModel;

@Module
class CompleteTestModule {

    @CompleteTestActivityScope
    @Provides
    CompleteTestModel provideTestSingleImageModel(UserCompletesTestUseCase userCompletesTestUseCase) {

        return new CompleteTestModel(
                userCompletesTestUseCase
        );
    }

    @CompleteTestActivityScope
    @Provides
    CompleteTestActivityPresenter provideTestSingleImageActivityPresenter(CompleteTestModel completeTestModel) {

        return new CompleteTestActivityPresenter(
                completeTestModel
        );
    }
}
