package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.CategoryWithWords

class MainGridCategoryAdapter(private val listOfAllCategoriesWithImageObjectsCount: List<CategoryWithWords>)
    : RecyclerView.Adapter<MainListCategoryViewHolder>() {

    override fun getItemCount(): Int {
        return listOfAllCategoriesWithImageObjectsCount.size
    }

    override fun onBindViewHolder(holder: MainListCategoryViewHolder, position: Int) {
        applyData(holder, listOfAllCategoriesWithImageObjectsCount[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapteritem_main_category_grid, parent, false)
        return MainListCategoryViewHolder(view)
    }

    private fun applyData(viewHolder: MainListCategoryViewHolder, categoryWithWords: CategoryWithWords) {
        viewHolder.showCategory(categoryWithWords.category, categoryWithWords.numberOfKnownWords, categoryWithWords.numberOfNotKnownWords)
    }
}
