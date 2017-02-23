package pl.edu.pjwstk.slowka.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import pl.edu.pjwstk.slowka.R
import java.util.*

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
        return display.text.toString()
    }

    fun setShuffledLettersForWord(typeableWord: String) {
        keyboard.removeAllViews()
        val shuffledUniqueLetters = extractUniqueLettersThenShuffle(typeableWord)
        val addingLetter = selectLetterSize(shuffledUniqueLetters)
        shuffledUniqueLetters.forEach { letter ->
            addingLetter(letter)
        }
    }

    private fun extractUniqueLettersThenShuffle(typeableWord: String): List<Char> {
        val uniqueLetters = mutableListOf<Char>()
        typeableWord.toLowerCase().toList().forEach { letter ->
            if (!uniqueLetters.contains(letter)) {
                if (uniqueLetters.isEmpty()) {
                    uniqueLetters.add(letter)
                } else {
                    uniqueLetters.add(Random().nextInt(uniqueLetters.size), letter)
                }
            }
        }
        return uniqueLetters
    }

    private fun selectLetterSize(lettersSet: List<Char>): (Char) -> Unit {
        return if (lettersSet.size < 7) {
            addBigLetterButton()
        } else if (lettersSet.size < 11) {
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
