package pl.edu.pjwstk.slowka.presentation.presenter.recognize

import pl.edu.pjwstk.slowka.presentation.presenter.Presenter
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivityView

abstract class RecognizeImageActivityPresenter : Presenter<RecognizeImageActivityView>() {
    abstract fun confirmButtonClicked()
}
