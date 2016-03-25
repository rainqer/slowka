package pl.edu.pjwstk.slowka.presentation.ui.cropp

import pl.edu.pjwstk.slowka.presentation.dagger.HasComponent
import pl.edu.pjwstk.slowka.presentation.dagger.cropp.CroppImageActivityComponent
import pl.edu.pjwstk.slowka.presentation.presenter.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.presenter.cropp.CroppImageActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaActivity
import javax.inject.Inject

class CroppImageActivity : SlowkaActivity<CroppImageActivityView>(),
        CroppImageActivityView,
        HasComponent<CroppImageActivityComponent?> {

    @Inject
    protected lateinit var presenter: CroppImageActivityPresenter

    override var component: CroppImageActivityComponent? = null
    override val activityPresenter: ActivityPresenter<CroppImageActivityView>
        get() = presenter

}
