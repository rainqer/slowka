package pl.edu.pjwstk.slowka.ui.camera

import android.content.Context
import android.view.SurfaceHolder
import android.view.SurfaceView
import pl.edu.pjwstk.slowka.presenter.camera.CameraActivityPresenterImpl

class CameraView : SurfaceView, SurfaceHolder.Callback {

    val cameraActivityPresenter: CameraActivityPresenterImpl

    override fun surfaceCreated(holder: SurfaceHolder) {
        cameraActivityPresenter.cameraSurfaceReady(holder)
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        cameraActivityPresenter.cameraSurfaceRefresh()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        holder.removeCallback(this)
    }

    constructor(context: Context, presenter: CameraActivityPresenterImpl) : super(context) {
        this.cameraActivityPresenter = presenter
        holder.addCallback(this)
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }
}
