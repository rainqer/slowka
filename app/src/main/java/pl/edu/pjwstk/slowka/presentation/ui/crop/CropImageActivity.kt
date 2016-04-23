package pl.edu.pjwstk.slowka.presentation.ui.crop

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import butterknife.bindView
import com.edmodo.cropper.CropImageView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.HasComponent
import pl.edu.pjwstk.slowka.presentation.ui.crop.dagger.CropImageActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.crop.dagger.CropImageActivityComponentAssembler
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
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

    override val croppedImage: Bitmap
        get() = cropImageView.croppedImage

    private val cropImageView : CropImageView by bindView(R.id.croppImage)
    private val cropButton : FloatingActionButton by bindView(R.id.fab)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbar(R.layout.activity_cropimage)
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
            presenter.cropButtonClicked()
        }
    }

    override fun showImage(bitmap: Bitmap) {
        cropImageView.setImageBitmap(bitmap)
    }

    companion object {
        final val FILE_NAME_KEY : String = "fileKey"
        fun createIntent(context: Context, file : File): Intent {
            return Intent(context, CropImageActivity::class.java)
                    .putExtra(FILE_NAME_KEY, file.absolutePath)
        }
    }
}
