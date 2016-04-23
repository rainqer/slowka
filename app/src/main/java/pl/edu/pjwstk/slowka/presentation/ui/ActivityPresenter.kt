package pl.edu.pjwstk.slowka.presentation.ui

abstract class ActivityPresenter <T : Any> : Presenter<T>() {

    abstract fun resume()
    abstract fun pause()

}
