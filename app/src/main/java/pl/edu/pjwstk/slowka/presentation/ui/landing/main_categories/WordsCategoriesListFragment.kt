package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import android.animation.TimeInterpolator
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.ActionBarActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
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
    val mainContainer : CoordinatorLayout by bindView(R.id.mainContainerForFab)
    val mainCategoryList : RecyclerView by bindView(R.id.mainScreenCategoryWordsList)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_user_categories_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.learning_screen)
        fab.setOnClickListener {
            startActivity(CameraActivity.createIntent(activity))
        }
        mainCategoryList.layoutManager = LinearLayoutManager(context)
        Components.from<LandingActivityComponent>(activity).inject(this)
        attachPresenter(this, activity, savedInstanceState)
    }

    override fun getMainCategoriesList(): RecyclerView {
        return mainCategoryList
    }

    override fun showInfoWordHasBeenAdded(recentlyAddedWord: String) {
        Snackbar.make(fab, getSnackBarText(recentlyAddedWord), Snackbar.LENGTH_INDEFINITE).apply {
            setAction(android.R.string.ok) { dismiss() }
            getView().addOnAttachStateChangeListener( object: View.OnAttachStateChangeListener {
                override fun onViewAttachedToWindow(v: View ) {
                }

                @Override
                override fun onViewDetachedFromWindow(v: View) {
                    fab.animate().translationY(0f).setInterpolator(AccelerateDecelerateInterpolator()).start();
                }
            });
        }.show()
    }

    private fun getSnackBarText(recentlyAddedWord: String) = Html.fromHtml(getString(R.string.word_has_been_added).format(recentlyAddedWord))

    override val fragmentPresenter: FragmentPresenter<WordsCategoriesView>
        get() = presenter

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }
}
