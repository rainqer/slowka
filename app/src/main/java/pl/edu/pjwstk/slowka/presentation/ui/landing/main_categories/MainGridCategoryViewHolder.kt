package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import pl.edu.pjwstk.slowka.R

class MainGridCategoryViewHolder {

    val icon: ImageView
    val name: TextView

    constructor(view: View) {
        icon = view.findViewById(R.id.adapterItem_category_icon) as ImageView
        name = view.findViewById(R.id.adapterItem_category_name) as TextView
    }
}
