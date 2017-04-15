package pl.edu.pjwstk.slowka.presentation.view

import android.content.Context
import android.util.AttributeSet
import pl.edu.pjwstk.slowka.R

class MediumLetterButton : LetterButton {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun getFontSize(): Float {
        return 22f
    }

    override fun getSideSize(): Int {
        return 40
    }

    override fun getBackgroundColor(): Int {
        return R.color.colorAccent
    }
}
