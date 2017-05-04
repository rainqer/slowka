package pl.edu.pjwstk.slowka.presentation.ui.single_category.words_list

import android.support.v7.widget.RecyclerView
import android.view.View

interface SingleCategoryWordsListView {
    fun getListOfWords(): RecyclerView
    fun setTitle(title: String)
    fun showPlaceHolder()
}
