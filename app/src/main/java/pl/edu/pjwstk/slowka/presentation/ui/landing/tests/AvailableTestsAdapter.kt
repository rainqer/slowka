package pl.edu.pjwstk.slowka.presentation.ui.landing.tests

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.CategoryWithWords

class AvailableTestsAdapter(private val listOfAllCategoriesWithImageObjectsCount: List<CategoryWithWords>)
    : RecyclerView.Adapter<AvailableTestViewHolder>() {

    override fun getItemCount(): Int {
        return listOfAllCategoriesWithImageObjectsCount.size
    }

    override fun onBindViewHolder(holder: AvailableTestViewHolder, position: Int) {
        applyData(holder, listOfAllCategoriesWithImageObjectsCount[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvailableTestViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapteritem_main_category_grid, parent, false)
        return AvailableTestViewHolder(view)
    }

    private fun applyData(viewHolder: AvailableTestViewHolder, categoryWithWords: CategoryWithWords) {
        viewHolder.showCategory(categoryWithWords.category, categoryWithWords.numberOfKnownWords, categoryWithWords.numberOfNotKnownWords)
    }
}
