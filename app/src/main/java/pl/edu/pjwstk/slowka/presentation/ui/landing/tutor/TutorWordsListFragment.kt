package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaFragment

abstract class TutorWordsListFragment constructor() : SlowkaFragment<TutorWordsListView>(), TutorWordsListView {

    val listOfWordsWithAnnotations : RecyclerView by bindView(R.id.wordsList)
    val placeholderNew : View by bindView(R.id.placeholder_new_empty)
    val placeholderLearn : View by bindView(R.id.placeholder_learn_empty)
    val placeholderKnow : View by bindView(R.id.placeholder_know_empty)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_tutor_words_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) listOfWordsWithAnnotations.post {
            (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.admin_screen)
        }
    }

    override fun getListOfWords(): RecyclerView {
        return listOfWordsWithAnnotations
    }
}
