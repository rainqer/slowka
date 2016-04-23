package pl.edu.pjwstk.slowka.presentation.ui.crop

import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.crop.CropImageActivityView

abstract class CropImageActivityPresenter : ActivityPresenter<CropImageActivityView>() {
    abstract fun cropButtonClicked()
}
