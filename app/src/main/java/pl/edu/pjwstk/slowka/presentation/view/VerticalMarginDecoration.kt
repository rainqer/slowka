package pl.edu.pjwstk.slowka.presentation.view

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class VerticalMarginDecoration() : RecyclerView.ItemDecoration() {

    private val margin: Int = 6

    override fun getItemOffsets(outRect: Rect,
                                view: View,
                                parent: RecyclerView,
                                state: RecyclerView.State?) {
        outRect.bottom = margin
        outRect.top = margin
        outRect.right = margin
        outRect.left = margin
    }
}
