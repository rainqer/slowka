package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.Toast
import pl.edu.pjwstk.slowka.domain.content.ImageObject
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
        Toast.makeText(presentedActivity, "${presentedActivity.intent.getStringExtra(CATEGORY_NAME_KEY)}", Toast.LENGTH_LONG).show()
        refreshListSubscription =
                singleCategoryWordsListModel.getReadyImages(presentedActivity.intent.getStringExtra(CATEGORY_NAME_KEY)).subscribe {
                    imageObjects -> buildListFromCursor(imageObjects)
                }
    }

    private fun buildListFromCursor(imageObjects: List<ImageObject>) {
        adapter.setData(imageObjects)
        presentedView.getListOfWords().invalidate()
    }

    override fun pause() {
        adapter.setData(emptyList<ImageObject>())
        refreshListSubscription.unsubscribe()
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }

    companion object {
        val CATEGORY_NAME_KEY = "categoryNameKey"
    }
}
