package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor

import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager

interface TutorFragmentView {
    fun getViewPager(): ViewPager
    fun getWordsListTabs(): TabLayout
    fun getChildFragmentManager(): FragmentManager
}
