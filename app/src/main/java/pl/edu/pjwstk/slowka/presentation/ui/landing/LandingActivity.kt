package pl.edu.pjwstk.slowka.presentation.ui.landing

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.view.Menu
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.HasComponent
import pl.edu.pjwstk.slowka.presentation.ui.landing.dagger.LandingActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.landing.dagger.LandingActivityComponentAssembler
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaActivityWithDrawer
import pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories.WordsCategoriesListFragment
import javax.inject.Inject

class LandingActivity : SlowkaActivityWithDrawer<LandingActivityView>(),
        LandingActivityView,
        HasComponent<LandingActivityComponent?> {

    @Inject
    protected lateinit var presenter: LandingActivityPresenter
    override var component: LandingActivityComponent? = null
    override val activityPresenter: ActivityPresenter<LandingActivityView>
        get() = presenter
    override val drawerSelectionListener: NavigationView.OnNavigationItemSelectedListener
        get() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbarAndDrawerNavigation(R.layout.activity_landing)
        setDaggerComponent(LandingActivityComponentAssembler.assemble(application, this))
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        attachPresenter(this, this, savedInstanceState)
        showFragment(WordsCategoriesListFragment())
    }

    private fun setDaggerComponent(component: LandingActivityComponent) {
        this.component = component
        this.component?.inject(this)
    }

    override fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.content, fragment)
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.landing, menu)
        return true
    }

    override fun closeDrawer() {
        super.closeSideDrawer()
    }
}
