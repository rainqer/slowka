package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_new

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

class NewWordsListFragment : TutorWordsListFragment() {

    @Inject
    protected lateinit var presenter: NewWordsListFragmentPresenter
    override val fragmentPresenter: FragmentPresenter<TutorWordsListView>
        get() = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getListOfWords().layoutManager = LinearLayoutManager(context)
        getListOfWords().addItemDecoration(VerticalMarginDecoration())
        Components.from<LandingActivityComponent>(activity).inject(this)
        attachPresenter(this, activity, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }

    override fun showPlaceholder() {
        placeholderNew.visibility = View.VISIBLE
    }

    override fun hidePlaceholder() {
        placeholderNew.visibility = View.GONE
    }

    companion object {
        fun getInstance() : NewWordsListFragment {
            return NewWordsListFragment()
        }

        @StringRes val titleRes: Int = R.string.admin_new_words
    }
}
