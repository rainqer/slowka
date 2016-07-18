package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.Toast
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.landing.TutorListOfWordsAdapter
import rx.Subscription
import rx.subscriptions.Subscriptions

class SingleCategoryActivityPresenter(private val singleCategoryWordsListModel: SingleCategoryWordsListModel)
    : ActivityPresenter<SingleCategoryActivityView>() {

    private var adapter : TutorListOfWordsAdapter? = null
    private var refreshListSubscription : Subscription = Subscriptions.unsubscribed()

    override fun attach(view: SingleCategoryActivityView, activity: FragmentActivity, savedInstanceState: Bundle?) {
        super.attach(view, activity, savedInstanceState)
        adapter = TutorListOfWordsAdapter(presentedActivity)
        presentedView.getListOfWords().adapter = adapter
    }

    override fun resume() {
        Toast.makeText(presentedActivity, "${presentedActivity.intent.getStringExtra(CATEGORY_NAME_KEY)}", Toast.LENGTH_LONG).show()
        refreshListSubscription =
                singleCategoryWordsListModel.getImages(presentedActivity.intent.getStringExtra(CATEGORY_NAME_KEY)).subscribe {
                    cursor -> buildListFromCursor(cursor)
                }
    }

    private fun buildListFromCursor(cursor: Cursor?) {
        adapter?.swapCursor(cursor)
        presentedView.getListOfWords().invalidate()
    }

    override fun pause() {
        adapter?.changeCursor(null)
        refreshListSubscription.unsubscribe()
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }

    companion object {
        val CATEGORY_NAME_KEY = "categoryNameKey"
    }
}
