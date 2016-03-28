package pl.edu.pjwstk.slowka.presentation.ui.landing

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.view.Menu
import butterknife.bindView
import pl.edu.pjwstk.slowka.presentation.presenter.ActivityPresenter
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.HasComponent
import pl.edu.pjwstk.slowka.presentation.dagger.landing.LandingActivityComponent
import pl.edu.pjwstk.slowka.presentation.dagger.landing.LandingActivityComponentAssembler
import pl.edu.pjwstk.slowka.presentation.presenter.landing.LandingActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaActivityWithDrawer
import pl.edu.pjwstk.slowka.presentation.ui.camera.CameraActivity
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

    val fab : FloatingActionButton by bindView(R.id.fab)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbarAndDrawerNavigation(R.layout.activity_landing)

        fab.setOnClickListener {
            startActivity(CameraActivity.createIntent(this))
        }

        setDaggerComponent(LandingActivityComponentAssembler.assemble(application))
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        attachPresenter(this, this, savedInstanceState)
    }

    private fun setDaggerComponent(component: LandingActivityComponent) {
        this.component = component
        this.component?.inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.landing, menu)
        return true
    }

    override fun closeDrawer() {
        super.closeSideDrawer()
    }
}
