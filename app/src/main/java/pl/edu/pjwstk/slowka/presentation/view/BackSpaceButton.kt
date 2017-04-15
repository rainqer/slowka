package pl.edu.pjwstk.slowka.presentation.view

import android.content.Context
import pl.edu.pjwstk.slowka.R

class BackSpaceButton(context: Context) : BigLetterButton(context) {
    override fun getBackgroundColor(): Int {
        return R.color.orange_dark
    }
}
