package pl.edu.pjwstk.slowka.presentation.presenter.landing

import android.support.v7.widget.LinearLayoutManager
import pl.edu.pjwstk.slowka.domain.content.ViewAllImageObjectsUseCase
import pl.edu.pjwstk.slowka.presentation.ui.landing.TutorListOfWordsAdapter
import pl.edu.pjwstk.slowka.repository.content.AndroidImageObjectRepository
import rx.schedulers.Schedulers

class TutorWordsListFragmentPresenterImpl : TutorWordsListFragmentPresenter() {

    private lateinit var adapter : TutorListOfWordsAdapter

    override fun onViewCreated() {
        ViewAllImageObjectsUseCase(AndroidImageObjectRepository(presentedActivity))
                .performAndObserve(Schedulers.io()).subscribe { cursor ->

                    presentedView.getListOfWords().setLayoutManager(LinearLayoutManager(presentedActivity))
                    adapter = TutorListOfWordsAdapter(presentedActivity, cursor)
                    presentedView.getListOfWords().setAdapter(adapter)
                }
    }

    override fun onDestroy() {
        adapter.changeCursor(null)
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        //NO OP
    }
}
