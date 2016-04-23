package pl.edu.pjwstk.slowka.presentation.ui.landing

import android.support.design.widget.NavigationView
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivityView

abstract class LandingActivityPresenter : ActivityPresenter<LandingActivityView>(),
        NavigationView.OnNavigationItemSelectedListener