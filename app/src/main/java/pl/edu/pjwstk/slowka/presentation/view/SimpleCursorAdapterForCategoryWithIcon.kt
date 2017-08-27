package pl.edu.pjwstk.slowka.presentation.view

import android.content.Context
import android.database.Cursor
import android.support.v4.widget.CursorAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.Category

class SimpleCursorAdapterForCategoryWithIcon(context: Context, cursor: Cursor, flags: Int)
    : CursorAdapter(context, cursor, flags) {

    override fun newView(context: Context, cursor: Cursor, parent: ViewGroup): View? {
        return LayoutInflater.from(context).inflate(R.layout.category_with_icon, parent, false)
    }

    override fun bindView(view: View, context: Context, cursor: Cursor) {
        val icon = view.findViewById(R.id.icon) as ImageView;
        val text = view.findViewById(R.id.text) as TextView;
        val category = Category(cursor)
        icon.setBackgroundResource(category.iconRes)
        text.text = context.getString(category.name)
    }
}
