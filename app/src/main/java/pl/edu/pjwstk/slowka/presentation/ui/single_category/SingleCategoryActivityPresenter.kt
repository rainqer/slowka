package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.Toast
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import rx.Subscription
import rx.subscriptions.Subscriptions

class SingleCategoryActivityPresenter(private val singleCategoryWordsListModel: SingleCategoryWordsListModel,
                                      private val adapter: SingleCategoryListOfWordsAdapter)
    : ActivityPresenter<SingleCategoryActivityView>() {

    private var refreshListSubscription : Subscription = Subscriptions.unsubscribed()

    override fun attach(view: SingleCategoryActivityView, activity: FragmentActivity, savedInstanceState: Bundle?) {
        super.attach(view, activity, savedInstanceState)
        presentedView.getListOfWords().adapter = adapter
    }

    override fun resume() {
        refreshListSubscription =
                singleCategoryWordsListModel.getReadyImages(presentedActivity.intent.getStringExtra(CATEGORY_NAME_KEY)).subscribe {
                    cursor -> buildListFromCursor(cursor)
                }
    }

    private fun buildListFromCursor(cursor: Cursor?) {
        adapter.swapCursor(cursor)
        presentedView.getListOfWords().invalidate()
    }

    override fun pause() {
        adapter.changeCursor(null)
        refreshListSubscription.unsubscribe()
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }

    companion object {
        val CATEGORY_NAME_KEY = "categoryNameKey"
    }
}
