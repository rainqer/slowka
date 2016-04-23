package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_know.IKnowWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_learn.ILearnWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list.i_new.NewWordsListFragment

class TutorListsPagerAdapter constructor(fragmentManager: FragmentManager)
    : FragmentStatePagerAdapter(fragmentManager) {

    private val NUMBER_OF_ALL_LISTS = 3

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ILearnWordsListFragment.getInstance()
            1 -> IKnowWordsListFragment.getInstance()
            2 -> NewWordsListFragment.getInstance()
            else -> ILearnWordsListFragment.getInstance()
        }
    }

    override fun getCount(): Int {
        return NUMBER_OF_ALL_LISTS
    }

}
