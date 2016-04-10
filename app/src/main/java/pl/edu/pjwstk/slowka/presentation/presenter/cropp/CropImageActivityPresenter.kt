package pl.edu.pjwstk.slowka.presentation.presenter.cropp

import pl.edu.pjwstk.slowka.presentation.presenter.Presenter
import pl.edu.pjwstk.slowka.presentation.ui.cropp.CropImageActivityView

abstract class CropImageActivityPresenter : Presenter<CropImageActivityView>() {
    abstract fun cropButtonClicked()
}
