package pl.edu.pjwstk.slowka.presentation.presenter.landing

import android.support.v4.app.Fragment
import android.view.MenuItem
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.ILearnWordsListFragment
import pl.edu.pjwstk.slowka.presentation.ui.landing.WordsCategoriesListFragment

class LandingActivityPresenterImpl() : LandingActivityPresenter() {

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        presentedView.closeDrawer()
        presentedView.showFragment(getFragmentToNavigateTo(menuItem))
        return true;
    }

    private fun getFragmentToNavigateTo(menuItem: MenuItem): Fragment {
        return when (menuItem.itemId) {
            R.id.nav_landing -> WordsCategoriesListFragment()
            R.id.nav_tutor -> ILearnWordsListFragment.getInstance()
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
