package pl.edu.pjwstk.presentation.ui.recognize

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import butterknife.bindView
import pl.edu.pjwstk.R
import pl.edu.pjwstk.presentation.dagger.HasComponent
import pl.edu.pjwstk.presentation.dagger.recognize.RecognizeImageActivityComponent
import pl.edu.pjwstk.presentation.dagger.recognize.RecognizeImageActivityComponentAssembler
import pl.edu.pjwstk.presentation.presenter.recognize.RecognizeImageActivityPresenter
import pl.edu.pjwstk.presentation.ui.SlowkaActivity
import pl.edu.pjwstk.presenter.ActivityPresenter
import java.io.File
import javax.inject.Inject

class RecognizeImageActivity : SlowkaActivity<RecognizeImageActivityView>(), RecognizeImageActivityView,
        HasComponent<RecognizeImageActivityComponent?> {

    @Inject
    protected lateinit var presenter: RecognizeImageActivityPresenter
    override var component: RecognizeImageActivityComponent? = null
    override val activityPresenter: ActivityPresenter<RecognizeImageActivityView>
        get() = presenter

    private lateinit var file : File

    private val fileNameView: TextView by bindView(R.id.fileName)

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
        fileNameView.text = file.absolutePath
    }

    companion object {
        final val FILE_NAME_KEY : String = "fileKey"
        fun createIntent(context: Context, file : File): Intent {
            return Intent(context, RecognizeImageActivity::class.java).putExtra(FILE_NAME_KEY, file.absolutePath)
        }
    }
}
