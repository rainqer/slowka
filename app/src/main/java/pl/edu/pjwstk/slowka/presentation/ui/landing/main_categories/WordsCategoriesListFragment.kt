package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.Components
import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaFragment
import pl.edu.pjwstk.slowka.presentation.ui.camera.CameraActivity
import pl.edu.pjwstk.slowka.presentation.ui.landing.dagger.LandingActivityComponent
import javax.inject.Inject

class WordsCategoriesListFragment @Inject constructor() : SlowkaFragment<WordsCategoriesView>(), WordsCategoriesView {

    @Inject
    protected lateinit var presenter: WordsCategoriesPresenter

    val fab : FloatingActionButton by bindView(R.id.fab)
    val mainCategoryGrid : GridView by bindView(R.id.mainScreenCategoryGrid)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_user_categories_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener {
            startActivity(CameraActivity.createIntent(activity))
        }
        Components.from<LandingActivityComponent>(activity).inject(this)
        attachPresenter(this, activity, savedInstanceState)
    }

    override fun getMainCategoriesGrid(): GridView {
        return mainCategoryGrid
    }

    override val fragmentPresenter: FragmentPresenter<WordsCategoriesView>
        get() = presenter
}
