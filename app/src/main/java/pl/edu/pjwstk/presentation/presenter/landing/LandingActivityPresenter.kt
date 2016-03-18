package pl.edu.pjwstk.presentation.presenter.landing

import android.support.design.widget.NavigationView
import pl.edu.pjwstk.presentation.presenter.ActivityPresenter
import pl.edu.pjwstk.presentation.ui.landing.LandingActivityView

abstract class LandingActivityPresenter : ActivityPresenter<LandingActivityView>(),
        NavigationView.OnNavigationItemSelectedListener