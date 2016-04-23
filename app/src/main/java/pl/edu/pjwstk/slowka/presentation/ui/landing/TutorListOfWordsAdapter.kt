package pl.edu.pjwstk.slowka.presentation.ui.landing

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
import skyfish.RecyclerViewCursorAdapter

class TutorListOfWordsAdapter (private val context: Context)
    : RecyclerViewCursorAdapter<TutorListOfWordsAdapter.TutorWordViewHolder>() {

    override fun onBindViewHolder(viewHolder: TutorWordViewHolder, cursor: Cursor) {
        val imageObject = ImageObject(cursor)
        viewHolder.itemAnnotation.text = imageObject.annotation
        Picasso.with(context).load(imageObject.imageFile).into(viewHolder.itemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorWordViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.holder_tutor_list_item, parent, false)
        return TutorWordViewHolder(itemView)
    }

    class TutorWordViewHolder : RecyclerView.ViewHolder {
        val itemAnnotation: TextView
        val itemImage: ImageView

        constructor(view : View) : super(view) {
            itemAnnotation = view.findViewById(R.id.itemName) as TextView
            itemImage = view.findViewById(R.id.itemImage) as ImageView
        }
    }
}
