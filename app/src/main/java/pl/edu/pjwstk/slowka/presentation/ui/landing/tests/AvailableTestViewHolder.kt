package pl.edu.pjwstk.slowka.presentation.ui.landing.tests

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.Category

class AvailableTestViewHolder : RecyclerView.ViewHolder {

    private val background: View
    private val icon: ImageView
    private val name: TextView
    private val progress: RoundCornerProgressBar
    private val numberOfWords: TextView
    private val onCategoryForTestSelectedListener: OnCategoryForTestSelectedListener
    private var shownCategoryName: String? = null

    constructor(view: View, onCategoryForTestSelectedListener: OnCategoryForTestSelectedListener) : super(view) {
        background = view.findViewById(R.id.background)
        icon = view.findViewById(R.id.adapterItem_category_icon) as ImageView
        name = view.findViewById(R.id.adapterItem_category_name) as TextView
        progress = view.findViewById(R.id.adapterItem_progress) as RoundCornerProgressBar
        numberOfWords = view.findViewById(R.id.adapterItem_number_of_words) as TextView
        icon.setColorFilter(ContextCompat.getColor(view.context, android.R.color.black));
        this.onCategoryForTestSelectedListener = onCategoryForTestSelectedListener
    }

    fun showCategory(category: Category, numberOfKnownWords: Int, numberOfUnknownWords : Int) {
        val totalNumberOfWords = numberOfKnownWords + numberOfUnknownWords
        icon.setImageResource(category.iconRes)
        name.text = itemView.context.getString(category.name)
        progress.max = totalNumberOfWords.toFloat()
        progress.progress = numberOfKnownWords.toFloat()
        numberOfWords.text = "$numberOfKnownWords/$totalNumberOfWords"
        shownCategoryName = itemView.context.getString(category.name)
        itemView.setOnClickListener { view ->
            onCategoryForTestSelectedListener.onCategoryForTestSelected(category)
        }
        background.setBackgroundColor(ContextCompat.getColor(background.context, category.color))
    }
}
