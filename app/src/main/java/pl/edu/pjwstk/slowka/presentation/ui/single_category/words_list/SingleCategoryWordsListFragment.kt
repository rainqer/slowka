package pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list

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
import pl.edu.pjwstk.slowka.presentation.ui.camera.CameraActivity

abstract class SingleCategoryWordsListFragment constructor()
    : SlowkaFragment<SingleCategoryWordsListView>(), SingleCategoryWordsListView {

    val listOfWordsWithAnnotations : RecyclerView by bindView(R.id.wordsList)
    val placeholderEmpty : View by bindView(R.id.placeholder_empty)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_tutor_words_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        placeholderEmpty.setOnClickListener {
            activity.finish()
            startActivity(CameraActivity.createIntent(activity))
        }
    }

    override fun getListOfWords(): RecyclerView {
        return listOfWordsWithAnnotations
    }

    override fun setTitle(title: String) {
        Handler().postDelayed( {
            (activity as AppCompatActivity).supportActionBar?.setTitle(title)
        }, 10);
    }

    override fun showPlaceHolder() {
        placeholderEmpty.visibility = View.VISIBLE
    }
}
