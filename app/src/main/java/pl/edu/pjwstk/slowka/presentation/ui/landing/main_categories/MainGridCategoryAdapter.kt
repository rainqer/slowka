package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import android.content.Context
import android.database.Cursor
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.presentation.view.RandomColorGenerator
import java.util.*

class MainGridCategoryAdapter(context: Context, c: Cursor, autoRequery: Boolean)
    : CursorAdapter(context, c, autoRequery) {

    override fun newView(context: Context, cursor: Cursor, viewGroup: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.adapteritem_main_category_grid, viewGroup, false)
        view.tag = MainGridCategoryViewHolder(view)
        applyData(view, cursor)
        return view
    }

    override fun bindView(view: View, context: Context, cursor: Cursor) {
        view.setBackgroundColor(RandomColorGenerator().nextRandomColor())
        applyData(view, cursor)
    }

    private fun applyData(view: View, cursor: Cursor) {
        val viewHolder = view.tag as MainGridCategoryViewHolder
        val category = Category(cursor)
        viewHolder.icon.setImageResource(category.iconRes)
        viewHolder.name.setText(category.name)
    }
}
