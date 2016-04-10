package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaFragment

abstract class TutorWordsListFragment constructor() : SlowkaFragment<TutorWordsListView>(), TutorWordsListView {

    val listOfWordsWithAnnotations : RecyclerView by bindView(R.id.wordsList)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_tutor_words_list, container, false)
    }

    override fun getListOfWords(): RecyclerView {
        return listOfWordsWithAnnotations
    }
}
