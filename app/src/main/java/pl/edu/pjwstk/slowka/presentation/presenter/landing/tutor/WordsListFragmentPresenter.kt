package pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor

import android.database.Cursor
import android.support.v7.widget.LinearLayoutManager
import pl.edu.pjwstk.slowka.domain.UseCase
import pl.edu.pjwstk.slowka.presentation.presenter.FragmentPresenter
import pl.edu.pjwstk.slowka.presentation.presenter.landing.TutorListOfWordsAdapter
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

    abstract internal fun LoadImagesUseCase() : UseCase<Cursor>;

    private fun buildListFromCursor(cursor: Cursor?) {
        presentedView.getListOfWords().setLayoutManager(LinearLayoutManager(presentedActivity))
        adapter = TutorListOfWordsAdapter(presentedActivity, cursor)
        presentedView.getListOfWords().setAdapter(adapter)
    }

    override fun onDestroy() {
        refreshListSubscription.unsubscribe()
        adapter?.changeCursor(null)
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        //NO OP
    }
}
