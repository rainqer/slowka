package pl.edu.pjwstk.presentation.presenter

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat

abstract class  ActivityPresenter <T : Any>{

    private lateinit var activityView: T
    protected val presentedView : T
        get() = activityView
    private lateinit var activity: Activity
    protected val presentedActivity : Activity
        get() = activity

    open fun attach(activityView: T,
                    activity: Activity,
                    savedInstanceState: Bundle?) {
        this.activityView = activityView
        this.activity = activity
    }

    abstract fun resume()
    abstract fun pause()

    protected fun permissionGranted(permission: String) = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB
            && ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED)

    protected fun startActivity(intent : Intent) {
        activity.startActivity(intent)
    }
}
