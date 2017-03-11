package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import android.support.v7.widget.RecyclerView

interface WordsCategoriesView {
    fun getMainCategoriesList(): RecyclerView
    fun showInfoWordHasBeenAdded(s: String)
}
