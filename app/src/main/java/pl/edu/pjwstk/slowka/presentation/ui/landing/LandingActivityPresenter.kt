package pl.edu.pjwstk.slowka.presentation.ui.landing

import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.landing.WordsCategoriesListFragment
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.TutorFragment

class LandingActivityPresenter() : ActivityPresenter<LandingActivityView>(),
        NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        presentedView.closeDrawer()
        presentedView.showFragment(getFragmentToNavigateTo(menuItem))
        return true;
    }

    private fun getFragmentToNavigateTo(menuItem: MenuItem): Fragment {
        return when (menuItem.itemId) {
            R.id.nav_landing -> WordsCategoriesListFragment()
            R.id.nav_tutor -> TutorFragment.getInstance()
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
