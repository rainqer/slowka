package pl.edu.pjwstk.slowka.presentation.ui.recognize

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.HasComponent
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaActivity
import pl.edu.pjwstk.slowka.presentation.ui.recognize.dagger.RecognizeImageActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.recognize.dagger.RecognizeImageActivityComponentAssembler
import java.io.File
import javax.inject.Inject

class RecognizeImageActivity : SlowkaActivity<RecognizeImageActivityView>(),
        RecognizeImageActivityView,
        HasComponent<RecognizeImageActivityComponent?> {

    @Inject
    protected lateinit var presenter: RecognizeImageActivityPresenter

    override var component: RecognizeImageActivityComponent? = null
    override val activityPresenter: ActivityPresenter<RecognizeImageActivityView>
        get() = presenter

    override val imageAnnotation: String
        get() = imageEditableAnnotation.text.toString()

    private val imageEditableAnnotation: EditText by bindView(R.id.annotationForImageContent)
    private val image: ImageView by bindView(R.id.image)
    private val progressBar: View by bindView(R.id.progressBar)
    private val confirmButton: FloatingActionButton by bindView(R.id.fab)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbar(R.layout.activity_recognizeimage)
        setDaggerComponent(RecognizeImageActivityComponentAssembler.assemble(application))
    }

    private fun setDaggerComponent(component: RecognizeImageActivityComponent) {
        this.component = component
        this.component?.inject(this)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        attachPresenter(this, this, savedInstanceState)
        confirmButton.setOnClickListener {
            presenter.confirmButtonClicked()
        }
    }

    override fun showAnnotationForRecognizedImage(annotationForImage: String) {
        imageEditableAnnotation.setText(annotationForImage)
        hideProgressBar()
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun setImage(bitmap: Bitmap) {
        image.setImageBitmap(bitmap)
    }

    companion object {
        final val FILE_NAME_KEY : String = "fileKey"
        fun createIntent(context: Context, file : File): Intent {
            return Intent(context, RecognizeImageActivity::class.java)
                    .putExtra(FILE_NAME_KEY, file.absolutePath)
        }
    }
}
