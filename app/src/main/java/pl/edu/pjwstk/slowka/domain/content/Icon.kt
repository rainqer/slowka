package pl.edu.pjwstk.slowka.domain.content

import android.support.annotation.DrawableRes
import pl.edu.pjwstk.slowka.R

enum class Icon (@DrawableRes val drawableRes : Int) {
    HOME(R.drawable.ic_home_black),
    SCHOOL(R.drawable.ic_grocery_black);

    companion object {
        public val HOME_ORDINAL = 0
        public val SCHOOL_ORDINAL = 1
        fun fromOrdinal(ordinal: Int): Icon {
            return when (ordinal) {
                HOME_ORDINAL -> HOME
                SCHOOL_ORDINAL -> SCHOOL
                else -> HOME
            }
        }
    }
}
