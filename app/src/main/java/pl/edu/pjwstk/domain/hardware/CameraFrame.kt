package pl.edu.pjwstk.domain.hardware

import android.graphics.Rect

class CameraFrame (val frame: ByteArray, val dimensions: Rect) {
    val isEmpty : Boolean
        get() = frame.isEmpty()
}
