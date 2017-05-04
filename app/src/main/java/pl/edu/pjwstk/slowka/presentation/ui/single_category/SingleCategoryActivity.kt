package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.HasComponent
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaActivity
import pl.edu.pjwstk.slowka.presentation.ui.single_category.dagger.SingleCategoryActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.single_category.dagger.SingleCategoryActivityComponentAssembler
import javax.inject.Inject

class SingleCategoryActivity : SlowkaActivity<SingleCategoryActivityView>(),
        SingleCategoryActivityView,
        HasComponent<SingleCategoryActivityComponent?> {

    @Inject
    protected lateinit var presenter: SingleCategoryActivityPresenter
    override var component: SingleCategoryActivityComponent? = null
    override val activityPresenter: ActivityPresenter<SingleCategoryActivityView>
        get() = presenter


    val viewPagerOfTutorWordsLists: ViewPager by bindView(R.id.pager)
    val tabs: TabLayout by bindView(R.id.wordsListPagerTabs)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbar(R.layout.activity_category_words_list)
        setDaggerComponent(SingleCategoryActivityComponentAssembler.assemble(application, this))
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.title = intent.getStringExtra(SingleCategoryActivityPresenter.CATEGORY_NAME_KEY)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        attachPresenter(this, this, savedInstanceState)
    }

    private fun setDaggerComponent(component: SingleCategoryActivityComponent) {
        this.component = component
        this.component?.inject(this)
    }

    override fun getViewPager(): ViewPager {
        return viewPagerOfTutorWordsLists
    }

    override fun getWordsListTabs(): TabLayout {
        return tabs
    }

    companion object {
        fun getIntent(context: Context, categoryName: String): Intent {
            return Intent(context, SingleCategoryActivity::class.java)
                    .putExtra(SingleCategoryActivityPresenter.CATEGORY_NAME_KEY, categoryName)
        }
    }
}
