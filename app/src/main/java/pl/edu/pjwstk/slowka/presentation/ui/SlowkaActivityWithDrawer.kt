package pl.edu.pjwstk.slowka.presentation.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import butterknife.bindView
import pl.edu.pjwstk.slowka.R

abstract class SlowkaActivityWithDrawer<T : Any> : SlowkaActivity<T>() {

    protected abstract val drawerSelectionListener: NavigationView.OnNavigationItemSelectedListener

    val navigationView : NavigationView by bindView(R.id.nav_view)
    val drawer : DrawerLayout by bindView(R.id.drawer_layout)

    fun setContentViewWithToolbarAndDrawerNavigation(layoutResID: Int) {
        super.setContentViewWithToolbar(layoutResID)
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onResume() {
        super.onResume()
        if (drawer == null) {
            throw AssertionError(INCOMPATIBLE_LAYOUT_ERROR)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        navigationView.setNavigationItemSelectedListener(drawerSelectionListener)
    }

    override fun onBackPressed() {
        closeSideDrawer()
        super.onBackPressed()
    }

    fun closeSideDrawer() {
        drawer.closeDrawer(GravityCompat.START)
    }

    companion object {
        private val INCOMPATIBLE_LAYOUT_ERROR =
                "setContentViewWithToolbarAndDrawerNavigation() " +
                        "not called on a view with nav_view and drawer_layout specified"
    }
}
