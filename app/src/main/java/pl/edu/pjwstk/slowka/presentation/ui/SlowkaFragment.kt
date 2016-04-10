package pl.edu.pjwstk.slowka.presentation.ui

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.presenter.FragmentPresenter

abstract class SlowkaFragment <T : Any>: Fragment() {

    protected val toolbar: Toolbar by bindView(R.id.toolbar)
    protected abstract val fragmentPresenter: FragmentPresenter<T>

    internal fun attachPresenter(fragmentView: T,
                                 activity: Activity,
                                 savedInstanceState: Bundle?) {
        fragmentPresenter.attach(fragmentView, activity, savedInstanceState)
        fragmentPresenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentPresenter.onDestroy()
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {

        fragmentPresenter.onRequestPermissionsResult(requestCode, grantResults)
    }
}
