package pl.edu.pjwstk.slowka.presentation.presenter.recognize

import pl.edu.pjwstk.slowka.presentation.presenter.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivityView

abstract class RecognizeImageActivityPresenter : ActivityPresenter<RecognizeImageActivityView>() {
    abstract fun confirmButtonClicked()
}
