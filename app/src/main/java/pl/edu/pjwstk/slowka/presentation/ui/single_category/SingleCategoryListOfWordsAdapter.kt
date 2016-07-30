package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.content.Context
import android.database.Cursor
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.AdminImageDetailsActivity
import skyfish.RecyclerViewCursorAdapter

class SingleCategoryListOfWordsAdapter (private val context: Context)
    : RecyclerViewCursorAdapter<SingleCategoryListOfWordsAdapter.SingleCategoryWordViewHolder>() {

    override fun onBindViewHolder(viewHolder: SingleCategoryWordViewHolder, cursor: Cursor) {
        val imageObject = ImageObject(cursor)
        viewHolder.itemAnnotation.text = imageObject.annotation
        viewHolder.itemCategory.text = imageObject.categoryName
        Picasso.with(context).load(imageObject.imageFile).into(viewHolder.itemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleCategoryWordViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.holder_tutor_list_item, parent, false)
        return SingleCategoryWordViewHolder(itemView)
    }

    class SingleCategoryWordViewHolder : RecyclerView.ViewHolder {
        val itemAnnotation: TextView
        val itemCategory: TextView
        val itemImage: ImageView

        constructor(view : View) : super(view) {
            itemAnnotation = view.findViewById(R.id.itemName) as TextView
            itemCategory = view.findViewById(R.id.categoryName) as TextView
            itemImage = view.findViewById(R.id.itemImage) as ImageView
        }
    }
}
