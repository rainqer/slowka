package pl.edu.pjwstk.slowka.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import pl.edu.pjwstk.slowka.R
import java.util.*

class MinimumInputWithDisplay : LinearLayout {

    private lateinit var answerDisplay: TextView
    private lateinit var keyboard: LinearLayout
    private lateinit var keyboard2: LinearLayout
    private lateinit var keyboard3: LinearLayout
    private lateinit var keyboard4: LinearLayout
    private lateinit var backSpaceKeyboard: LinearLayout

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        inflate(context, R.layout.minimum_input_with_display, this)
        answerDisplay = findViewById(R.id.display) as TextView
        keyboard = findViewById(R.id.keyboard) as LinearLayout
        keyboard2 = findViewById(R.id.keyboard2) as LinearLayout
        keyboard3 = findViewById(R.id.keyboard3) as LinearLayout
        keyboard4 = findViewById(R.id.keyboard4) as LinearLayout
        backSpaceKeyboard = findViewById(R.id.backSpaceKeyboard) as LinearLayout
    }

    fun getUserInput() : String {
        return answerDisplay.text.toString()
    }

    fun setShuffledLettersForWord(typeableWord: String) {
        keyboard.removeAllViews()
        val shuffledUniqueLetters = extractUniqueLettersThenShuffle(typeableWord)
        shuffledUniqueLetters.forEach { letter ->
            addingBigLetterButton(letter)
        }
        addBackSpace()
    }

    private val backspace = '\u232b'

    private fun extractUniqueLettersThenShuffle(typeableWord: String): List<Char> {
        return mutableListOf<Char>().apply {
            typeableWord
                    .toLowerCase()
                    .toList()
                    .forEach { letter -> insertLetterInRandomSpace(this, letter) }
        }
    }

    private fun insertLetterInRandomSpace(listOfCharacters: MutableList<Char>, letter: Char) {
        if (!listOfCharacters.contains(letter)) {
            if (listOfCharacters.isEmpty()) {
                listOfCharacters.add(letter)
            } else {
                listOfCharacters.add(Random().nextInt(listOfCharacters.size), letter)
            }
        }
    }

    private val addingBigLetterButton: (Char) -> Unit
            = { letter -> adjustButtonThenInsert(letter, BigLetterButton(context)) }

    private fun adjustButtonThenInsert(letter: Char, letterButton: LetterButton) {
        letterButton.text = letter.toString()
        letterButton.setOnClickListener { view ->
            answerDisplay.append((view as TextView).text)
        }
        if (keyboard.childCount <= 3) {
            keyboard.addView(letterButton, keyboard.childCount)
        } else if (keyboard2.childCount <= 3) {
            keyboard2.addView(letterButton, keyboard2.childCount)
        } else if (keyboard3.childCount <= 3) {
            keyboard3.addView(letterButton, keyboard3.childCount)
        } else {
            keyboard4.addView(letterButton, keyboard4.childCount)
        }
    }

    private fun addBackSpace() {
        val backspaceButton = BackSpaceButton(context).apply {
            text = backspace.toString()
            setOnClickListener { view ->
                val currentText = answerDisplay.text
                if (currentText.isNotEmpty()) {
                    answerDisplay.text = currentText.dropLast(1)
                }
            }
        }
        backSpaceKeyboard.addView(backspaceButton)
    }

    fun clear() {
        answerDisplay.text = null
    }
}
