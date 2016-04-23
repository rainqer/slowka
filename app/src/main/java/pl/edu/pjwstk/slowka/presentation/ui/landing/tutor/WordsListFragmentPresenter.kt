package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor

import android.database.Cursor
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import pl.edu.pjwstk.slowka.domain.UseCase
import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter
import android.support.v4.app.FragmentActivity
import pl.edu.pjwstk.slowka.presentation.ui.landing.TutorListOfWordsAdapter
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.TutorWordsListView
import rx.Subscription
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

abstract class WordsListFragmentPresenter : FragmentPresenter<TutorWordsListView>() {

    private var adapter : TutorListOfWordsAdapter? = null
    private var refreshListSubscription : Subscription = Subscriptions.unsubscribed()

    override fun onViewCreated() {
        refreshListSubscription =
                LoadImagesUseCase().performAndObserve(Schedulers.io()).subscribe { cursor ->
                    buildListFromCursor(cursor)
                }
    }

    override fun attach(view: TutorWordsListView, activity: FragmentActivity, savedInstanceState: Bundle?) {
        super.attach(view, activity, savedInstanceState)
        presentedView.getListOfWords().setLayoutManager(LinearLayoutManager(presentedActivity))
        adapter = TutorListOfWordsAdapter(presentedActivity)
        presentedView.getListOfWords().setAdapter(adapter)
    }

    abstract internal fun LoadImagesUseCase() : UseCase<Cursor>;

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
