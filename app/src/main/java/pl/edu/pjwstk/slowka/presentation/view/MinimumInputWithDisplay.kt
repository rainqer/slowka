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

    fun getUserInput() : String {
        return display.text
    }

    fun setShuffledLettersForWord(typeableWord: String) {
        keyboard.removeAllViews()
        val addingLetter = selectLetterSize(typeableWord)
        typeableWord.toList().forEach { letter ->
            addingLetter(letter)
        }
    }

    private fun selectLetterSize(typeableWord: String): (Char) -> Unit {
        return if (typeableWord.length < 7) {
            addBigLetterButton()
        } else if (typeableWord.length < 11) {
            addMediumLetterButton()
        } else {
            addSmallLetterButton()
        }
    }

    private fun addSmallLetterButton(): (Char) -> Unit {
        return { letter -> adjustButtonThenInsert(letter, SmallLetterButton(context)) }
    }

    private fun addMediumLetterButton(): (Char) -> Unit {
        return { letter -> adjustButtonThenInsert(letter, MediumLetterButton(context)) }
    }

    private fun addBigLetterButton(): (Char) -> Unit {
        return { letter -> adjustButtonThenInsert(letter, BigLetterButton(context)) }
    }

    private fun adjustButtonThenInsert(letter: Char, letterButton: LetterButton) {
        letterButton.text = letter.toString()
        letterButton.setOnClickListener { view ->
            display.append((view as TextView).text)
        }
        keyboard.addView(letterButton, 0)
    }
}
