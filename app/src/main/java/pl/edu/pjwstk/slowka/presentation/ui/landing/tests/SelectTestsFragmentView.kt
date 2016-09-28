package pl.edu.pjwstk.slowka.presentation.ui.landing.tests

import android.support.v7.widget.RecyclerView

interface SelectTestsFragmentView {
    fun getAvailableTestsView() : RecyclerView
    fun showDidntStartTest()
}
