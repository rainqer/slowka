package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.Components
import pl.edu.pjwstk.slowka.presentation.ui.landing.dagger.LandingActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.TutorFragmentPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaFragment
import javax.inject.Inject

class TutorFragment : SlowkaFragment<TutorFragmentView>(), TutorFragmentView {

    @Inject
    protected lateinit var presenter: TutorFragmentPresenter
    override val fragmentPresenter: FragmentPresenter<TutorFragmentView>
        get() = presenter

    val viewPagerOfTutorWordsLists: ViewPager by bindView(R.id.pager)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_tutor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Components.from<LandingActivityComponent>(activity).inject(this)
        attachPresenter(this, activity, savedInstanceState)
    }

    override fun getViewPager(): ViewPager {
        return viewPagerOfTutorWordsLists
    }

    companion object {
        fun getInstance() : TutorFragment {
            return TutorFragment()
        }
    }
}
