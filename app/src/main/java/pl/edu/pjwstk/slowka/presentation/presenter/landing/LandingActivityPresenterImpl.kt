package pl.edu.pjwstk.slowka.presentation.presenter.landing

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MenuItem
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivityView
import pl.edu.pjwstk.slowka.presentation.ui.landing.TutorWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.landing.WordsCategoriesListFragment

class LandingActivityPresenterImpl : LandingActivityPresenter() {

    private lateinit var landingActivityView: LandingActivityView
    private lateinit var activity: Activity

    override fun attach(activityView: LandingActivityView, activity: Activity, savedInstanceState: Bundle?) {
        this.landingActivityView = activityView
        this.activity = activity
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        landingActivityView.closeDrawer()
        landingActivityView.showFragment(getFragmentToNavigateTo(menuItem))
        return true;
    }

    private fun getFragmentToNavigateTo(menuItem: MenuItem): Fragment {
        return when (menuItem.itemId) {
            R.id.nav_landing -> WordsCategoriesListFragment()
            R.id.nav_tutor -> TutorWordsListFragment()
            else -> WordsCategoriesListFragment()
        }
    }

    override fun resume() {
    }

    override fun pause() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }
}
