package pl.edu.pjwstk.slowka.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import pl.edu.pjwstk.slowka.R

class MinimumInputWithDisplay : LinearLayout {

    private lateinit var display: TextView
    private lateinit var keyboard: LinearLayout

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        inflate(context, R.layout.minimum_input_with_display, this)
        display = findViewById(R.id.display) as TextView
        keyboard = findViewById(R.id.keyboard) as LinearLayout
    }

    fun setShuffledLettersForWord(typeableWord: String) {
        keyboard.removeAllViews()
        typeableWord.toList().forEach { letter ->
            addLetterButton(letter)
        }
//        keyboard.invalidate()
    }

    private fun addLetterButton(letter: Char) {
        val letterButton = LetterButton(context)
//        val letterButton = TextView(context)
        letterButton.text = letter.toString()
        letterButton.setOnClickListener { view ->
            display.append((view as TextView).text)
        }
        keyboard.addView(letterButton, 0)
    }
}
