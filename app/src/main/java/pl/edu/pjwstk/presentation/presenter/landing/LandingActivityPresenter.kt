package pl.edu.pjwstk.presentation.presenter.landing

import android.support.design.widget.NavigationView
import pl.edu.pjwstk.presenter.ActivityPresenter
import pl.edu.pjwstk.presentation.ui.landing.LandingActivityView

interface LandingActivityPresenter : ActivityPresenter<LandingActivityView>,
        NavigationView.OnNavigationItemSelectedListener