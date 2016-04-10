package pl.edu.pjwstk.slowka.presentation.ui.landing

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.ViewAllImageObjectsUseCase
import pl.edu.pjwstk.slowka.presentation.presenter.FragmentPresenter
import pl.edu.pjwstk.slowka.presentation.presenter.landing.LandingActivityPresenter
import pl.edu.pjwstk.slowka.presentation.presenter.landing.TutorWordsListFragmentPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaFragment
import pl.edu.pjwstk.slowka.repository.content.AndroidImageObjectRepository
import rx.schedulers.Schedulers
import javax.inject.Inject

class TutorWordsListFragment @Inject constructor() : SlowkaFragment<TutorWordsListView>(), TutorWordsListView {

    @Inject
    protected lateinit var presenter: TutorWordsListFragmentPresenter

    override val fragmentPresenter: FragmentPresenter<TutorWordsListView>
        get() = presenter

    val listOfWordsWithAnnotations : RecyclerView by bindView(R.id.wordsList)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_tutor_words_list, container, false)
    }

    override fun getListOfWords(): RecyclerView {
        return listOfWordsWithAnnotations
    }
}
