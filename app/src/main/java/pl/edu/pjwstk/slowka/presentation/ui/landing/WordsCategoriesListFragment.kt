package pl.edu.pjwstk.slowka.presentation.ui.landing

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.ui.camera.CameraActivity
import javax.inject.Inject

class WordsCategoriesListFragment @Inject constructor() : Fragment() {

    val fab : FloatingActionButton by bindView(R.id.fab)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_user_categories_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener {
            startActivity(CameraActivity.createIntent(activity))
        }
    }
}
