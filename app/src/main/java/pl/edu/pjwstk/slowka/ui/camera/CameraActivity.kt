package pl.edu.pjwstk.slowka.ui.camera

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import butterknife.bindView
import pl.edu.pjwstk.presenter.ActivityPresenter
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.dagger.camera.CameraActivityComponent
import pl.edu.pjwstk.slowka.dagger.camera.CameraActivityComponentAssembler
import pl.edu.pjwstk.slowka.presenter.camera.CameraActivityPresenter
import pl.edu.pjwstk.slowka.presenter.camera.Ratio
import pl.edu.pjwstk.slowka.ui.SlowkaActivity
import pl.touk.id_scanner.dagger.HasComponent
import javax.inject.Inject

class CameraActivity : SlowkaActivity<CameraActivityView>(), CameraActivityView ,
        HasComponent<CameraActivityComponent?> {

    @Inject
    protected lateinit var presenter: CameraActivityPresenter
    override var component: CameraActivityComponent? = null
    override val activityPresenter: ActivityPresenter<CameraActivityView>
        get() = presenter

    private val cameraContainer: FrameLayout by bindView(R.id.cameraContainer)
    private var cameraView: CameraView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbar(R.layout.activity_words_camera_view)
        setDaggerComponent(CameraActivityComponentAssembler.assemble(application))
    }

    private fun setDaggerComponent(component: CameraActivityComponent) {
        this.component = component
        this.component?.inject(this)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        attachPresenter(this, this, savedInstanceState)
    }

    override fun setupCameraPreviewRatio(ratio: Ratio) {
        val display = window.windowManager.defaultDisplay
        val params = cameraContainer.layoutParams?: FrameLayout.LayoutParams(0, 0)

        val width = ratio.getWidthInPortrait(display.width, display.height)
        val height = ratio.getHeightInPortrait(width)
        params.width = width
        params.height = height
        cameraContainer.layoutParams = params
    }

    override fun onPause() {
        super.onPause()
        tearDownCameraSurface()
    }

    override fun setupSurfaceForCameraAndUnblock() {
        cameraView = CameraView(this, presenter)
        cameraContainer.addView(cameraView)
    }

    private fun tearDownCameraSurface() {
        cameraContainer.removeView(cameraView)
        cameraView = null
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {

        presenter.onRequestPermissionsResult(requestCode, grantResults)
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CameraActivity::class.java)
        }
    }
}
