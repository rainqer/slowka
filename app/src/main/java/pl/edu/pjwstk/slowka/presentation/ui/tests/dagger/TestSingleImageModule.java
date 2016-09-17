package pl.edu.pjwstk.slowka.presentation.ui.tests.dagger;

import dagger.Module;
import dagger.Provides;
import pl.edu.pjwstk.slowka.domain.test.UserUploadsCurrentTestImageAnswerUseCase;
import pl.edu.pjwstk.slowka.domain.test.UserViewNextTestImageUseCase;
import pl.edu.pjwstk.slowka.presentation.ui.tests.TestSingleImageActivityPresenter;
import pl.edu.pjwstk.slowka.presentation.ui.tests.TestSingleImageModel;

@Module
class TestSingleImageModule {

    @TestSingleImageActivityScope
    @Provides
    TestSingleImageModel provideTestSingleImageModel(UserViewNextTestImageUseCase userViewNextTestImageUseCase,
                                                     UserUploadsCurrentTestImageAnswerUseCase userUploadsCurrentTestImageAnswerUseCase) {

        return new TestSingleImageModel(
                userViewNextTestImageUseCase,
                userUploadsCurrentTestImageAnswerUseCase
        );
    }

    @TestSingleImageActivityScope
    @Provides
    TestSingleImageActivityPresenter provideTestSingleImageActivityPresenter(TestSingleImageModel testSingleImageModel) {

        return new TestSingleImageActivityPresenter(
                testSingleImageModel
        );
    }
}
