package pl.edu.pjwstk.slowka.presentation.ui.landing

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.tools.BitmapDecoder

class TutorListOfWordsAdapter (private val listOfImageObjects : List<ImageObject>)
    : RecyclerView.Adapter<TutorListOfWordsAdapter.TutorWordViewHolder>() {

    override fun onBindViewHolder(holder: TutorWordViewHolder, position: Int) {
        holder.itemAnnotation.text = listOfImageObjects.get(position).annotation
        holder.itemImage.setImageBitmap(
                BitmapDecoder(listOfImageObjects.get(position).imageFile).decode()
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorWordViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.holder_tutor_list_item, parent, false)
        return TutorWordViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listOfImageObjects.size
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
