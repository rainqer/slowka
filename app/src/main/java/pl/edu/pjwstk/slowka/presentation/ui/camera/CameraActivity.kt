package pl.edu.pjwstk.slowka.presentation.ui.camera

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.widget.FrameLayout
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.HasComponent
import pl.edu.pjwstk.slowka.presentation.ui.camera.dagger.CameraActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.camera.dagger.CameraActivityComponentAssembler
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.camera.CameraActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.camera.Ratio
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaActivity
import javax.inject.Inject

class CameraActivity : SlowkaActivity<CameraActivityView>(), CameraActivityView,
        HasComponent<CameraActivityComponent?> {

    @Inject
    protected lateinit var presenter: CameraActivityPresenter
    override var component: CameraActivityComponent? = null
    override val activityPresenter: ActivityPresenter<CameraActivityView>
        get() = presenter

    private val cameraContainer: FrameLayout by bindView(R.id.cameraContainer)
    private val cameraButton: FloatingActionButton by bindView(R.id.fab)
    private var cameraView: CameraPreviewView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbar(R.layout.activity_words_camera_view)
        toolbar.setTitle(R.string.camera_screen)
        setDaggerComponent(CameraActivityComponentAssembler.assemble(application))
    }

    private fun setDaggerComponent(component: CameraActivityComponent) {
        this.component = component
        this.component?.inject(this)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        attachPresenter(this, this, savedInstanceState)
        setupButtons()
    }

    private fun setupButtons() {
        cameraButton.setOnClickListener { view ->
            presenter.cameraButtonClicked()
        }
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
        cameraView = CameraPreviewView(this, presenter)
        cameraContainer.addView(cameraView)
    }

    private fun tearDownCameraSurface() {
        cameraContainer.removeView(cameraView)
        cameraView = null
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CameraActivity::class.java)
        }
    }
}
