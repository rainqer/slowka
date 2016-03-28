package pl.edu.pjwstk.slowka.presentation.ui.landing

import android.support.v4.app.Fragment

interface LandingActivityView {

    open fun closeDrawer()
    fun showFragment(fragment: Fragment)
}