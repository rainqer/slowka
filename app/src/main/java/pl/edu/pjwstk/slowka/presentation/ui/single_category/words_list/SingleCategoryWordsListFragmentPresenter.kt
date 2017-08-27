package pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list

import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivityPresenter
import rx.Subscription
import rx.subscriptions.Subscriptions

open class SingleCategoryWordsListFragmentPresenter (private val wordsListFragmentModel : SingleCategoryWordsListFragmentModel,
                                                     private val adapter : SingleCategoryListOfWordsAdapter)
    : FragmentPresenter<SingleCategoryWordsListView>() {

    private var refreshListSubscription : Subscription = Subscriptions.unsubscribed()

    override fun attach(view: SingleCategoryWordsListView, activity: FragmentActivity, savedInstanceState: Bundle?) {
        super.attach(view, activity, savedInstanceState)
        presentedView.getListOfWords().adapter = adapter
        presentedView.setTitle(
                presentedActivity.getString(
                        presentedActivity.intent.getIntExtra(SingleCategoryActivityPresenter.CATEGORY_NAME_KEY, -1)
                )
        )
    }

    override fun onViewCreated() {
        refresh()
    }

    private fun refresh() {
        refreshListSubscription =
                wordsListFragmentModel
                        .getImages(presentedActivity.intent.getIntExtra(SingleCategoryActivityPresenter.CATEGORY_NAME_KEY, -1))
                        .subscribe { cursor ->
                            buildListFromCursor(cursor)
                        }
    }

    private fun buildListFromCursor(cursor: Cursor?) {
        if (cursor?.count == 0) {
            presentedView.showPlaceHolder()
        } else {
            adapter.swapCursor(cursor)
            presentedView.getListOfWords().invalidate()
        }
    }

    override fun onDestroyView() {
        refreshListSubscription.unsubscribe()
        adapter.changeCursor(null)
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        //NO OP
    }
}
