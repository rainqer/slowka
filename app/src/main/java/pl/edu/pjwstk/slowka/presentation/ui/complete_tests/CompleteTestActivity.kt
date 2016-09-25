package pl.edu.pjwstk.slowka.presentation.ui.complete_tests

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import at.grabner.circleprogress.CircleProgressView
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.presentation.dagger.HasComponent
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaActivity
import pl.edu.pjwstk.slowka.presentation.ui.complete_tests.dagger.CompleteTestActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.complete_tests.dagger.CompleteTestActivityComponentAssembler
import javax.inject.Inject

class CompleteTestActivity : SlowkaActivity<CompleteTestActivityView>(),
        CompleteTestActivityView,
        HasComponent<CompleteTestActivityComponent?> {

    @Inject
    protected lateinit var presenter: CompleteTestActivityPresenter

    private val progressView: CircleProgressView by bindView(R.id.progress)
    private val okay: FloatingActionButton by bindView(R.id.fab)

    override var component: CompleteTestActivityComponent? = null
    override val activityPresenter: ActivityPresenter<CompleteTestActivityView>
        get() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbar(R.layout.activity_testcomplete)
        setDaggerComponent(CompleteTestActivityComponentAssembler.assemble(application))
    }

    private fun setDaggerComponent(component: CompleteTestActivityComponent) {
        this.component = component
        this.component?.inject(this)
    }

    override fun setResults(correct: Int, incorrect: Int) {
        progressView.setValue(0f)
        progressView.setValueAnimated(correct / (correct+incorrect) * 100f)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        attachPresenter(this, this, savedInstanceState)
        okay.setOnClickListener {
            finish()
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, CompleteTestActivity::class.java)
        }
    }
}
