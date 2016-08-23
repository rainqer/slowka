package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_know.IKnowWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_learn.ILearnWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_new.NewWordsListFragment

class TutorListsPagerAdapter constructor(fragmentManager: FragmentManager, context: Context)
    : FragmentStatePagerAdapter(fragmentManager) {

    private val NUMBER_OF_ALL_LISTS = 3
    private val newTitle : String
    private val learningTitle : String
    private val learntTitle : String

    init {
        newTitle = context.getString(NewWordsListFragment.titleRes)
        learningTitle = context.getString(ILearnWordsListFragment.titleRes)
        learntTitle = context.getString(IKnowWordsListFragment.titleRes)
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> NewWordsListFragment.getInstance()
            1 -> ILearnWordsListFragment.getInstance()
            2 -> IKnowWordsListFragment.getInstance()
            else -> throw IllegalArgumentException("could not view fragment for position $position")
        }
    }

    override fun getCount(): Int {
        return NUMBER_OF_ALL_LISTS
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> newTitle
            1 -> learningTitle
            2 -> learntTitle
            else -> throw IllegalArgumentException("could not find title for position $position")
        }
    }

}
