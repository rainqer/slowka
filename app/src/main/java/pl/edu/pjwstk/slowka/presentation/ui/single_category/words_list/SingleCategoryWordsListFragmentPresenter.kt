package pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list

import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.TutorWordsListView
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivityPresenter
import rx.Subscription
import rx.subscriptions.Subscriptions

open class SingleCategoryWordsListFragmentPresenter (private val wordsListFragmentModel : SingleCategoryWordsListFragmentModel,
                                                     private val adapter : SingleCategoryListOfWordsAdapter)
    : FragmentPresenter<TutorWordsListView>() {

    private var refreshListSubscription : Subscription = Subscriptions.unsubscribed()

    override fun attach(view: TutorWordsListView, activity: FragmentActivity, savedInstanceState: Bundle?) {
        super.attach(view, activity, savedInstanceState)
        presentedView.getListOfWords().adapter = adapter
    }

    override fun onViewCreated() {
        refresh()
    }

    private fun refresh() {
        refreshListSubscription =
                wordsListFragmentModel
                        .getImages(presentedActivity.intent.getStringExtra(SingleCategoryActivityPresenter.CATEGORY_NAME_KEY))
                        .subscribe { cursor ->
                            buildListFromCursor(cursor)
                        }
    }

    private fun buildListFromCursor(cursor: Cursor?) {
        adapter.swapCursor(cursor)
        presentedView.getListOfWords().invalidate()
    }

    override fun onDestroyView() {
        refreshListSubscription.unsubscribe()
        adapter.changeCursor(null)
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        //NO OP
    }
}
