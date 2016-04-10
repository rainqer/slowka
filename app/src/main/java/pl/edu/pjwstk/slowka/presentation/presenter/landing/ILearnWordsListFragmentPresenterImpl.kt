package pl.edu.pjwstk.slowka.presentation.presenter.landing

import android.database.Cursor
import android.support.v7.widget.LinearLayoutManager
import pl.edu.pjwstk.slowka.domain.content.ViewAllImageObjectsUseCase
import pl.edu.pjwstk.slowka.repository.content.AndroidImageObjectRepository
import rx.Subscription
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

class ILearnWordsListFragmentPresenterImpl : ILearnWordsListFragmentPresenter() {

    private var adapter : TutorListOfWordsAdapter? = null
    private var refreshListSubscription : Subscription = Subscriptions.unsubscribed()

    override fun onViewCreated() {
        refreshListSubscription =
                ViewAllImageObjectsUseCase(AndroidImageObjectRepository(presentedActivity))
                        .performAndObserve(Schedulers.io()).subscribe { cursor ->
                            buildListFromCursor(cursor)
                        }
    }

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
