package pl.edu.pjwstk.slowka.presentation.presenter

abstract class FragmentPresenter <T : Any> : Presenter<T>() {

    abstract fun onViewCreated()
    abstract fun onDestroyView()
}
