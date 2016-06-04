package pl.edu.pjwstk.slowka.domain.content

import android.support.annotation.DrawableRes
import pl.edu.pjwstk.slowka.R

enum class Icon (@DrawableRes val drawableRes : Int) {
    HOME(R.drawable.ic_home_black),
    SCHOOL(R.drawable.ic_grocery_black);

    companion object {
        fun fromOrdinal(ordinal: Int): Icon {
            return when (ordinal) {
                0 -> HOME
                1 -> SCHOOL
                else -> HOME
            }
        }
    }
}
