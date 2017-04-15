package pl.edu.pjwstk.slowka.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import butterknife.bindView
import pl.edu.pjwstk.slowka.R

class TestResultOverlay: LinearLayout {

    val nextButton: View by bindView(R.id.next)
    val redoButton: View by bindView(R.id.redo)
    private val happy: View by bindView(R.id.happy)
    private val sad: View by bindView(R.id.sad)

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        inflate(context, R.layout.test_result_overlay, this)
    }

    fun showOkay() {
        happy.visibility = View.VISIBLE
        sad.visibility = View.GONE
    }

    fun showNotOkay() {
        happy.visibility = View.GONE
        sad.visibility = View.VISIBLE
    }
}
