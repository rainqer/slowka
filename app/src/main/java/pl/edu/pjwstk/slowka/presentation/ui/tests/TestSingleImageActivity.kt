package pl.edu.pjwstk.slowka.presentation.ui.tests

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.widget.ImageView
import android.widget.ViewAnimator
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.HasComponent
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaActivity
import pl.edu.pjwstk.slowka.presentation.ui.tests.dagger.TestSingleImageActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.tests.dagger.TestSingleImageActivityComponentAssembler
import pl.edu.pjwstk.slowka.presentation.view.MinimumInputWithDisplay
import pl.edu.pjwstk.slowka.presentation.view.TestResultOverlay
import javax.inject.Inject

class TestSingleImageActivity : SlowkaActivity<TestSingleImageActivityView>(),
        TestSingleImageActivityView,
        HasComponent<TestSingleImageActivityComponent?> {

    @Inject
    protected lateinit var presenter: TestSingleImageActivityPresenter

    val testImageView: ImageView by bindView(R.id.testImage)
    val next: FloatingActionButton by bindView(R.id.fab)
    val keyboardWithDisplay: MinimumInputWithDisplay by bindView(R.id.keyboardWithDisplay)
    val testOverlay: TestResultOverlay by bindView(R.id.testOverlay)
    val animator: ViewAnimator by bindView(R.id.animator)

    override var component: TestSingleImageActivityComponent? = null
    override val activityPresenter: ActivityPresenter<TestSingleImageActivityView>
        get() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbar(R.layout.activity_testsingleimage)
        setDaggerComponent(TestSingleImageActivityComponentAssembler.assemble(application))
        toolbar.title = getString(R.string.testTitle)
    }

    private fun setDaggerComponent(component: TestSingleImageActivityComponent) {
        this.component = component
        this.component?.inject(this)
    }

    override fun showImage(image: Bitmap) {
        testImageView.setImageBitmap(image)
    }

    override fun adjustKeyboard(annotation: String) {
        keyboardWithDisplay.setShuffledLettersForWord(annotation)
    }

    override fun getAnswer(): String {
        return keyboardWithDisplay.getUserInput()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        attachPresenter(this, this, savedInstanceState)
        next.setOnClickListener {
            presenter.onOkayClicked()
        }
        testOverlay.nextButton.setOnClickListener { presenter.onNextClicked() }
        testOverlay.redoButton.setOnClickListener {
            animator.displayedChild = 0
            next.show()
            keyboardWithDisplay.clear()
        }
    }

    override fun showResult(result: Boolean) {
        if (result) testOverlay.showOkay() else testOverlay.showNotOkay()
        animator.displayedChild = 1
        next.hide()
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, TestSingleImageActivity::class.java)
        }
    }
}
