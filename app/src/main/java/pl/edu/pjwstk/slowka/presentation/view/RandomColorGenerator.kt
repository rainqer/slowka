package pl.edu.pjwstk.slowka.presentation.view

import android.graphics.Color
import android.support.annotation.ColorInt
import java.util.*

class RandomColorGenerator {

    @ColorInt
    fun nextRandomColor() : Int{
        val rnd = Random()
        return Color.argb(100, randomColorPart(rnd), randomColorPart(rnd), randomColorPart(rnd))
    }

    private fun randomColorPart(rnd: Random) = rnd.nextInt(128) + 128
}
