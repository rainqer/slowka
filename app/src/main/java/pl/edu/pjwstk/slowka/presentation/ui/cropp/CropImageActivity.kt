package pl.edu.pjwstk.slowka.presentation.ui.cropp

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import butterknife.bindView
import com.edmodo.cropper.CropImageView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.HasComponent
import pl.edu.pjwstk.slowka.presentation.dagger.cropp.CropImageActivityComponent
import pl.edu.pjwstk.slowka.presentation.dagger.cropp.CropImageActivityComponentAssembler
import pl.edu.pjwstk.slowka.presentation.presenter.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.presenter.cropp.CropImageActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaActivity
import java.io.File
import javax.inject.Inject

class CropImageActivity : SlowkaActivity<CropImageActivityView>(),
        CropImageActivityView,
        HasComponent<CropImageActivityComponent?> {

    @Inject
    protected lateinit var presenter: CropImageActivityPresenter

    override var component: CropImageActivityComponent? = null
    override val activityPresenter: ActivityPresenter<CropImageActivityView>
        get() = presenter

    private val cropImageView : CropImageView by bindView(R.id.croppImage)
    private val cropButton : Button by bindView(R.id.fab)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbar(R.layout.activity_recognizeimage)
        setDaggerComponent(CropImageActivityComponentAssembler.assemble(application))
    }

    private fun setDaggerComponent(component: CropImageActivityComponent) {
        this.component = component
        this.component?.inject(this)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        attachPresenter(this, this, savedInstanceState)
        cropButton.setOnClickListener {
            presenter.cropButtonClicked(cropImageView.croppedImage)
        }
    }

    override fun showImage(bitmap: Bitmap) {
        cropImageView.setImageBitmap(bitmap)
    }

    companion object {
        final val FILE_NAME_KEY : String = "fileKey"
        fun createIntent(context: Context, file : File): Intent {
            return Intent(context, CropImageActivity::class.java)
                    .putExtra(CropImageActivity.Companion.FILE_NAME_KEY, file.absolutePath)
        }
    }
}
