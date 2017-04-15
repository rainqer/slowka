package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_know.IKnowWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_learn.ILearnWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.all.SingleCategoryAcceptedWordsFragment

class SingleCategoryListsPagerAdapter constructor(fragmentManager: FragmentManager, context: Context)
    : FragmentStatePagerAdapter(fragmentManager) {

    private val NUMBER_OF_ALL_LISTS = 1
    private val learningTitle : String
    private val learntTitle : String
    private val allAcceptedTitle : String

    init {
        learningTitle = context.getString(ILearnWordsListFragment.titleRes)
        learntTitle = context.getString(IKnowWordsListFragment.titleRes)
        allAcceptedTitle = context.getString(R.string.admin_learning_words)
    }

    override fun getItem(position: Int): Fragment {
        return SingleCategoryAcceptedWordsFragment.getInstance()
    }

    override fun getCount(): Int {
        return NUMBER_OF_ALL_LISTS
    }

    override fun getPageTitle(position: Int): CharSequence {
        return allAcceptedTitle
    }

}
