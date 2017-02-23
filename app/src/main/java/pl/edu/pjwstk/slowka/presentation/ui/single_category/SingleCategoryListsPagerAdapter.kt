package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_know.IKnowWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_learn.ILearnWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.known.SingleCategoryKnownWordsFragment
import pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list.learning.SingleCategoryLearningWordsFragment

class SingleCategoryListsPagerAdapter constructor(fragmentManager: FragmentManager, context: Context)
    : FragmentStatePagerAdapter(fragmentManager) {

    private val NUMBER_OF_ALL_LISTS = 2
    private val learningTitle : String
    private val learntTitle : String

    init {
        learningTitle = context.getString(ILearnWordsListFragment.titleRes)
        learntTitle = context.getString(IKnowWordsListFragment.titleRes)
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> SingleCategoryLearningWordsFragment.getInstance()
            1 -> SingleCategoryKnownWordsFragment.getInstance()
            else -> throw IllegalArgumentException("could not view fragment for position $position")
        }
    }

    override fun getCount(): Int {
        return NUMBER_OF_ALL_LISTS
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> learningTitle
            1 -> learntTitle
            else -> throw IllegalArgumentException("could not find title for position $position")
        }
    }

}
