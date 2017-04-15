package pl.edu.pjwstk.slowka.domain.content

import android.support.annotation.DrawableRes
import pl.edu.pjwstk.slowka.R

enum class Icon (@DrawableRes val drawableRes : Int) {
    HOME(R.drawable.ic_home_black),
    HOBBY(R.drawable.ic_golf),
    FOOD(R.drawable.ic_spoon),
    PEOPLE(R.drawable.ic_face_black),
    ACTIVITIES(R.drawable.ic_sport_black),
    OTHER(R.drawable.ic_more_horiz);

    companion object {
        private val HOME_ORDINAL = 0
        private val HOBBY_ORDINAL = 1
        private val FOOD_ORDINAL = 2
        private val PEOPLE_ORDINAL = 3
        private val ACTIVITIES_ORDINAL = 4
        private val OTHER_ORDINAL = 5
        fun fromOrdinal(ordinal: Int): Icon {
            return when (ordinal) {
                HOME_ORDINAL -> HOME
                HOBBY_ORDINAL -> HOBBY
                FOOD_ORDINAL -> FOOD
                PEOPLE_ORDINAL -> PEOPLE
                ACTIVITIES_ORDINAL -> ACTIVITIES
                OTHER_ORDINAL -> OTHER
                else -> HOME
            }
        }
    }
}
