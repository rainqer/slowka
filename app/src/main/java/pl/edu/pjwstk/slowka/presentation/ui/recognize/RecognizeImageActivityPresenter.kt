package pl.edu.pjwstk.slowka.presentation.ui.recognize

import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.recognize.RecognizeImageActivityView

abstract class RecognizeImageActivityPresenter : ActivityPresenter<RecognizeImageActivityView>() {
    abstract fun confirmButtonClicked()
}
