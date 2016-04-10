package pl.edu.pjwstk.slowka.presentation.presenter.landing

import android.support.design.widget.NavigationView
import pl.edu.pjwstk.slowka.presentation.presenter.Presenter
import pl.edu.pjwstk.slowka.presentation.ui.landing.LandingActivityView

abstract class LandingActivityPresenter : Presenter<LandingActivityView>(),
        NavigationView.OnNavigationItemSelectedListener