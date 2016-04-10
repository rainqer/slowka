package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor

import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager

interface TutorFragmentView {
    fun getViewPager(): ViewPager
    fun getChildFragmentManager(): FragmentManager
}
