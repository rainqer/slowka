package pl.edu.pjwstk.slowka.presentation.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import pl.edu.pjwstk.slowka.R

abstract class LetterButton : TextView {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    val scale = context.resources.displayMetrics.density

    private fun init() {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, getFontSize())
        val size = getSizeInDp()
//        setPadding(padding, padding, padding, padding)
        val newLayoutParams = LinearLayout.LayoutParams(size, size)
        newLayoutParams.setMargins(30, 0, 30, 0);
        setBackgroundResource(getBackgroundColor())
        gravity= Gravity.CENTER
        foreground = getSelectedItemDrawable()
        ViewCompat.setElevation(this, 10f)
        setTextColor(ContextCompat.getColor(context, android.R.color.white))
        layoutParams = newLayoutParams
    }

    private fun getSizeInDp() = (getSideSize() * scale + 0.5).toInt()

    fun getSelectedItemDrawable(): Drawable {
        val attrs = intArrayOf(R.attr.selectableItemBackground)
        val ta = context.obtainStyledAttributes(attrs);
        val selectedItemDrawable = ta.getDrawable(0);
        ta.recycle();
        return selectedItemDrawable;
    }

    abstract fun getFontSize(): Float
    abstract fun getSideSize(): Int
    @ColorRes
    abstract fun getBackgroundColor(): Int
}
