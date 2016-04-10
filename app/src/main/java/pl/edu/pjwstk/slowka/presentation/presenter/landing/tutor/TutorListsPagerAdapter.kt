package pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.IKnowWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.ILearnWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.NewWordsListFragment

class TutorListsPagerAdapter constructor(fragmentManager: FragmentManager)
    : FragmentPagerAdapter(fragmentManager) {

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
