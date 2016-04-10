package pl.edu.pjwstk.slowka.presentation.presenter.cropp

import pl.edu.pjwstk.slowka.presentation.presenter.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.cropp.CropImageActivityView

abstract class CropImageActivityPresenter : ActivityPresenter<CropImageActivityView>() {
    abstract fun cropButtonClicked()
}
