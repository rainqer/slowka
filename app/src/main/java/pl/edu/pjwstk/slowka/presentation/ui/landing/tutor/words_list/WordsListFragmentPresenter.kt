package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.words_list

import android.database.Cursor
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter
import android.support.v4.app.FragmentActivity
import pl.edu.pjwstk.slowka.presentation.ui.landing.TutorListOfWordsAdapter
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.TutorWordsListView
import pl.edu.pjwstk.slowka.presentation.view.VerticalMarginDecoration
import rx.Subscription
import rx.subscriptions.Subscriptions

open class WordsListFragmentPresenter (private val wordsListFragmentModel : WordsListFragmentModel)
    : FragmentPresenter<TutorWordsListView>() {

    private var adapter : TutorListOfWordsAdapter? = null
    private var refreshListSubscription : Subscription = Subscriptions.unsubscribed()

    override fun onViewCreated() {
        refreshListSubscription =
                wordsListFragmentModel.getImages().subscribe { cursor ->
                    buildListFromCursor(cursor)
                }
    }

    override fun attach(view: TutorWordsListView, activity: FragmentActivity, savedInstanceState: Bundle?) {
        super.attach(view, activity, savedInstanceState)
        presentedView.getListOfWords().setLayoutManager(LinearLayoutManager(presentedActivity))
        presentedView.getListOfWords().addItemDecoration(VerticalMarginDecoration())
        adapter = TutorListOfWordsAdapter(presentedActivity)
        presentedView.getListOfWords().setAdapter(adapter)
    }

    private fun buildListFromCursor(cursor: Cursor?) {
        adapter?.swapCursor(cursor)
        presentedView.getListOfWords().invalidate()
    }

    override fun onDestroyView() {
        refreshListSubscription.unsubscribe()
        adapter?.changeCursor(null)
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        //NO OP
    }
}
