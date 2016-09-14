package pl.edu.pjwstk.slowka.presentation.ui.landing.tests

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.Components
import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaFragment
import pl.edu.pjwstk.slowka.presentation.ui.landing.dagger.LandingActivityComponent
import javax.inject.Inject

class SelectTestsFragment : SlowkaFragment<SelectTestsFragmentView>(), SelectTestsFragmentView {

    @Inject
    protected lateinit var presenter: SelectTestsFragmentPresenter
    override val fragmentPresenter: FragmentPresenter<SelectTestsFragmentView>
        get() = presenter

    val allAvailableTestsView: RecyclerView by bindView(R.id.availableTests)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_tests, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Components.from<LandingActivityComponent>(activity).inject(this)
        attachPresenter(this, activity, savedInstanceState)
    }

    override fun getAvailableTestsView(): RecyclerView {
        return allAvailableTestsView
    }

    companion object {
        fun getInstance() : SelectTestsFragment {
            return SelectTestsFragment()
        }
    }
}