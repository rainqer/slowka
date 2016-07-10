package pl.edu.pjwstk.slowka.domain.content

import android.support.annotation.DrawableRes
import pl.edu.pjwstk.slowka.R

enum class Icon (@DrawableRes val drawableRes : Int) {
    HOME(R.drawable.ic_home_black),
    SPORT(R.drawable.ic_sport_black),
    WEATHER(R.drawable.ic_weather_black),
    PEOPLE(R.drawable.ic_face_black),
    HOLIDAY(R.drawable.ic_holiday_black),
    GROCERY(R.drawable.ic_grocery_black);

    companion object {
        private val HOME_ORDINAL = 0
        private val SPORT_ORDINAL = 1
        private val WEATHER_ORDINAL = 2
        private val PEOPLE_ORDINAL = 3
        private val HOLIDAY_ORDINAL = 4
        private val GROCERY_ORDINAL = 5
        fun fromOrdinal(ordinal: Int): Icon {
            return when (ordinal) {
                HOME_ORDINAL -> HOME
                SPORT_ORDINAL -> SPORT
                WEATHER_ORDINAL -> WEATHER
                PEOPLE_ORDINAL -> PEOPLE
                HOLIDAY_ORDINAL -> HOLIDAY
                GROCERY_ORDINAL -> GROCERY
                else -> HOME
            }
        }
    }
}
