package pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.all

import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.Components
import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter
import pl.edu.pjwstk.slowka.presentation.ui.single_category.dagger.SingleCategoryActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.SingleCategoryWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.SingleCategoryWordsListView
import pl.edu.pjwstk.slowka.presentation.view.VerticalMarginDecoration
import javax.inject.Inject

class SingleCategoryAcceptedWordsFragment : SingleCategoryWordsListFragment(), SingleCategoryWordsListView {

    @Inject
    protected lateinit var presenter: SingleCategoryAcceptedWordsFragmentPresenter
    override val fragmentPresenter: FragmentPresenter<SingleCategoryWordsListView>
        get() = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getListOfWords().layoutManager = LinearLayoutManager(context)
        getListOfWords().addItemDecoration(VerticalMarginDecoration())
        Components.from<SingleCategoryActivityComponent>(activity).inject(this)
        attachPresenter(this, activity, savedInstanceState)
    }

    companion object {
        fun getInstance() : SingleCategoryAcceptedWordsFragment {
            return SingleCategoryAcceptedWordsFragment()
        }

        @StringRes val titleRes: Int = R.string.admin_learning_words
    }
}
