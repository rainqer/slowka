package pl.edu.pjwstk.slowka.presentation.ui.tutor

import android.os.Bundle
import android.view.View
import pl.edu.pjwstk.slowka.presentation.dagger.Components
import pl.edu.pjwstk.slowka.presentation.dagger.landing.LandingActivityComponent
import pl.edu.pjwstk.slowka.presentation.presenter.FragmentPresenter
import pl.edu.pjwstk.slowka.presentation.presenter.landing.ILearnWordsListFragmentPresenter
import javax.inject.Inject

class ILearnWordsListFragment constructor() : TutorWordsListFragment() {

    @Inject
    protected lateinit var presenter: ILearnWordsListFragmentPresenter
    override val fragmentPresenter: FragmentPresenter<TutorWordsListView>
        get() = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Components.from<LandingActivityComponent>(activity).inject(this)
        attachPresenter(this, activity, savedInstanceState)
    }

    companion object {
        fun getInstance() : ILearnWordsListFragment {
            return ILearnWordsListFragment()
        }
    }
}
