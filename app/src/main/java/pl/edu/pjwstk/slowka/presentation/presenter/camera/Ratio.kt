package pl.edu.pjwstk.slowka.presentation.presenter.camera

enum class Ratio(private val ratio: Float) {
    FOUR_TO_THREE(4f / 3f);

    fun getWidthInPortrait(width: Int, height: Int): Int {
        if (ratio * width <= height) {
            return width.toInt()
        } else {
            return (1f / ratio * width).toInt()
        }
    }

    fun getHeightInPortrait(width: Int): Int {
        return (ratio * width).toInt()
    }
}