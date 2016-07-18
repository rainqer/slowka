package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivity

class MainGridCategoryViewHolder {

    private val icon: ImageView
    private val name: TextView
    private var shownCategoryName: String? = null

    constructor(view: View) {
        icon = view.findViewById(R.id.adapterItem_category_icon) as ImageView
        name = view.findViewById(R.id.adapterItem_category_name) as TextView
        view.setOnClickListener {
            view -> launchSingleCategoryActivity(view)
        }
    }

    private fun launchSingleCategoryActivity(view: View) {
        view.context.startActivity(SingleCategoryActivity.getIntent(view.context, getCategoryOrThrow()))
    }

    private fun getCategoryOrThrow() =
            shownCategoryName ?: throw IllegalStateException("Trying to show category which does not exist")

    fun showCategory(category: Category) {
        icon.setImageResource(category.iconRes)
        name.text = category.name
        shownCategoryName = category.name
    }
}
