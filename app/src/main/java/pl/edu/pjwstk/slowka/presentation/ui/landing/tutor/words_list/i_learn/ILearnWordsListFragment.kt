package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_learn

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.Components
import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter
import pl.edu.pjwstk.slowka.presentation.ui.landing.dagger.LandingActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.TutorWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.TutorWordsListView
import pl.edu.pjwstk.slowka.presentation.view.VerticalMarginDecoration
import javax.inject.Inject

class ILearnWordsListFragment : TutorWordsListFragment() {

    @Inject
    protected lateinit var presenter: ILearnWordsListFragmentPresenter
    override val fragmentPresenter: FragmentPresenter<TutorWordsListView>
        get() = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getListOfWords().setLayoutManager(LinearLayoutManager(context))
        getListOfWords().addItemDecoration(VerticalMarginDecoration())
        Components.from<LandingActivityComponent>(activity).inject(this)
        attachPresenter(this, activity, savedInstanceState)
    }

    companion object {
        fun getInstance() : ILearnWordsListFragment {
            return ILearnWordsListFragment()
        }

        @StringRes val titleRes: Int = R.string.admin_learning_words
    }
}
