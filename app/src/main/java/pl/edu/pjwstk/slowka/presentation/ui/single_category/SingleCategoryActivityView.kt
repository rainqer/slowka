package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.support.design.widget.TabLayout
import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewPager

interface SingleCategoryActivityView {
    fun getViewPager(): ViewPager
    fun getWordsListTabs(): TabLayout
    fun getSupportFragmentManager(): FragmentManager
}