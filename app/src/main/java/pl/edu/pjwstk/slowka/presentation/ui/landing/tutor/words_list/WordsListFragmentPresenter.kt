package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list

import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter
import pl.edu.pjwstk.slowka.presentation.ui.landing.TutorListOfWordsAdapter
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.TutorWordsListView
import rx.Subscription
import rx.subscriptions.Subscriptions

open class WordsListFragmentPresenter (private val wordsListFragmentModel : WordsListFragmentModel,
                                       private val adapter : TutorListOfWordsAdapter)
    : FragmentPresenter<TutorWordsListView>() {

    private var refreshListSubscription : Subscription = Subscriptions.unsubscribed()

    override fun attach(view: TutorWordsListView, activity: FragmentActivity, savedInstanceState: Bundle?) {
        super.attach(view, activity, savedInstanceState)
        presentedView.getListOfWords().adapter = adapter
    }

    override fun onViewCreated() {
        refresh()
    }

    fun resume() {
        refresh()
    }

    private fun refresh() {
        refreshListSubscription =
                wordsListFragmentModel.getImages().subscribe { cursor ->
                    buildListFromCursor(cursor)
                }
    }

    private fun buildListFromCursor(cursor: Cursor?) {
        if (cursor?.count == 0) {
            presentedView.showPlaceholder()
        } else {
            presentedView.hidePlaceholder()
        }
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
