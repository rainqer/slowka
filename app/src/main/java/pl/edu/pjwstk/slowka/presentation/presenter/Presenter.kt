package pl.edu.pjwstk.slowka.presentation.presenter

import android.annotation.TargetApi
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat

abstract class Presenter <T : Any> {

    private lateinit var view: T
    protected val presentedView : T
        get() = view
    private lateinit var activity: FragmentActivity
    protected val presentedActivity : FragmentActivity
        get() = activity

    open fun attach(view: T,
                    activity: FragmentActivity,
                    savedInstanceState: Bundle?) {
        this.view = view
        this.activity = activity
    }

    abstract fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray)

    @TargetApi(Build.VERSION_CODES.M)
    protected fun permissionGranted(permission: String) =
            userCanDenyPermissionForThisVersion() && userGrantedPermission(permission)

    @TargetApi(Build.VERSION_CODES.M)
    protected fun requestPermission(permission: String, requestCode: Int) {
        if (userCanDenyPermissionForThisVersion()) {
            activity.requestPermissions(arrayOf(permission), requestCode)
        }
    }

    private fun userCanDenyPermissionForThisVersion() =
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

    private fun userGrantedPermission(permission: String) =
            ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED

    protected fun startActivity(intent : Intent) {
        activity.startActivity(intent)
    }
}
