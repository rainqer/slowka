package pl.edu.pjwstk.slowka.presentation.view

import android.content.Context
import android.util.AttributeSet

class SmallLetterButton : LetterButton {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun getFontSize(): Float {
        return 18f
    }

    override fun getPaddingSize(): Int {
        return 20
    }

}
