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
import pl.edu.pjwstk.slowka.repository.content.AndroidImageObjectRepository
import rx.schedulers.Schedulers
import javax.inject.Inject

class TutorWordsListFragment @Inject constructor() : Fragment() {

    private val listOfWords : RecyclerView by bindView(R.id.wordsList)
    private lateinit var adapter : TutorListOfWordsAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_tutor_words_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //move to presenter
        ViewAllImageObjectsUseCase(AndroidImageObjectRepository(context))
                .performAndObserve(Schedulers.io()).subscribe { cursor ->

            listOfWords.setLayoutManager(LinearLayoutManager(context))
            adapter = TutorListOfWordsAdapter(context, cursor)
            listOfWords.setAdapter(adapter)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        adapter.changeCursor(null)
    }
}
