package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor

import android.os.Bundle
import android.view.View
import pl.edu.pjwstk.slowka.presentation.dagger.Components
import pl.edu.pjwstk.slowka.presentation.dagger.landing.LandingActivityComponent
import pl.edu.pjwstk.slowka.presentation.presenter.FragmentPresenter
import pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor.NewWordsListFragmentPresenter
import javax.inject.Inject

class NewWordsListFragment constructor() : TutorWordsListFragment() {

    @Inject
    protected lateinit var presenter: NewWordsListFragmentPresenter
    override val fragmentPresenter: FragmentPresenter<TutorWordsListView>
        get() = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Components.from<LandingActivityComponent>(activity).inject(this)
        attachPresenter(this, activity, savedInstanceState)
    }

    companion object {
        fun getInstance() : NewWordsListFragment {
            return NewWordsListFragment()
        }
    }
}
