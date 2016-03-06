package pl.edu.pjwstk.slowka.presenter.landing

import android.support.design.widget.NavigationView
import pl.edu.pjwstk.presenter.ActivityPresenter
import pl.edu.pjwstk.slowka.ui.landing.LandingActivityView

interface LandingActivityPresenter : ActivityPresenter<LandingActivityView>,
        NavigationView.OnNavigationItemSelectedListener