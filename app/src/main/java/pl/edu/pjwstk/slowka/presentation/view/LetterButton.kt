package pl.edu.pjwstk.slowka.presentation.view

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import pl.edu.pjwstk.slowka.R

class LetterButton : TextView {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 22f)
        setPadding(40, 40, 40, 40)
        val newLayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        newLayoutParams.setMargins(10, 0, 10, 0);
        setBackgroundResource(R.color.colorAccent)
        setTextColor(ContextCompat.getColor(context, android.R.color.white))
        layoutParams = newLayoutParams
    }
}
