package pl.edu.pjwstk.slowka.presentation.ui.admin_image_details

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import pl.edu.pjwstk.slowka.R

class CategoryViewHolder {

    val icon: ImageView
    val name: TextView
    val chosenIndicator: View

    constructor(view: View) {
        icon = view.findViewById(R.id.adapterItem_category_icon) as ImageView
        name = view.findViewById(R.id.adapterItem_category_name) as TextView
        chosenIndicator = view.findViewById(R.id.chosenIndicator) as ImageView
    }
}
