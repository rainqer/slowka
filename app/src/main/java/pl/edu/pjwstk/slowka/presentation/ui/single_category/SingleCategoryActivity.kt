package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.content.Context
import android.content.Intent
import android.os.Bundle
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

    val listOfWordsWithAnnotations : RecyclerView by bindView(R.id.wordsList)

    @Inject
    protected lateinit var presenter: SingleCategoryActivityPresenter
    override var component: SingleCategoryActivityComponent? = null
    override val activityPresenter: ActivityPresenter<SingleCategoryActivityView>
        get() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbar(R.layout.activity_category_words_list)
        setDaggerComponent(SingleCategoryActivityComponentAssembler.assemble(application))
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        attachPresenter(this, this, savedInstanceState)
    }

    private fun setDaggerComponent(component: SingleCategoryActivityComponent) {
        this.component = component
        this.component?.inject(this)
    }

    override fun getListOfWords(): RecyclerView {
        return listOfWordsWithAnnotations
    }

    companion object {
        fun getIntent(context: Context, categoryId: Int): Intent {
            return Intent(context, SingleCategoryActivity::class.java)
                    .putExtra(SingleCategoryActivityPresenter.CATEGORY_ID_KEY, categoryId)
        }
    }
}
