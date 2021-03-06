package pl.edu.pjwstk.slowka.presentation.ui.admin_image_details

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.CategoryViewHolder

class CategoryAdapter(context: Context, c: Cursor, autoRequery: Boolean)
    : CursorAdapter(context, c, autoRequery) {

    override fun newView(context: Context, cursor: Cursor, viewGroup: ViewGroup): View {
        val view = LayoutInflater.from(context).inflate(R.layout.adapteritem_category_grid, viewGroup, false)
        view.tag = CategoryViewHolder(view)
        applyData(view, cursor)
        return view
    }

    override fun bindView(view: View, context: Context, cursor: Cursor) {
        applyData(view, cursor)
    }

    private fun applyData(view: View, cursor: Cursor) {
        val viewHolder = view.tag as CategoryViewHolder
        val category = Category(cursor)
        viewHolder.icon.setImageResource(category.iconRes)
        viewHolder.name.setText(category.name)
        viewHolder.chosenIndicator.visibility = if (cursor.position == selected) View.VISIBLE else View.GONE
    }

    fun getSelectedCategory() : Category {
        cursor.moveToPosition(selected)
        return Category(cursor)
    }

    var selected: Int = 0
}
