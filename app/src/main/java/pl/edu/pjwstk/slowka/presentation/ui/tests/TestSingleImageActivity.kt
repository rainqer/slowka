package pl.edu.pjwstk.slowka.presentation.ui.tests

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.widget.EditText
import android.widget.ImageView
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.HasComponent
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaActivity
import pl.edu.pjwstk.slowka.presentation.ui.tests.dagger.TestSingleImageActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.tests.dagger.TestSingleImageActivityComponentAssembler
import javax.inject.Inject

class TestSingleImageActivity : SlowkaActivity<TestSingleImageActivityView>(),
        TestSingleImageActivityView,
        HasComponent<TestSingleImageActivityComponent?> {

    @Inject
    protected lateinit var presenter: TestSingleImageActivityPresenter

    val testImageView: ImageView by bindView(R.id.testImage)
    val answerText: EditText by bindView(R.id.answer)
    val next: FloatingActionButton by bindView(R.id.fab)

    override var component: TestSingleImageActivityComponent? = null
    override val activityPresenter: ActivityPresenter<TestSingleImageActivityView>
        get() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbar(R.layout.activity_testsingleimage)
        setDaggerComponent(TestSingleImageActivityComponentAssembler.assemble(application))
    }

    private fun setDaggerComponent(component: TestSingleImageActivityComponent) {
        this.component = component
        this.component?.inject(this)
    }

    override fun showImage(image: Bitmap) {
        testImageView.setImageBitmap(image)
    }

    override fun getAnswer(): String {
        return answerText.text.toString()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        attachPresenter(this, this, savedInstanceState)
        next.setOnClickListener {
            presenter.onNextClicked()
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, TestSingleImageActivity::class.java)
        }
    }
}
