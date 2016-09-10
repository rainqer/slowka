package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.content.Context
import android.database.Cursor
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dd.processbutton.iml.ActionProcessButton
import com.squareup.picasso.Picasso
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.presentation.speech.Speaker
import skyfish.RecyclerViewCursorAdapter

class SingleCategoryListOfWordsAdapter (private val context: Context,
                                        private val speaker: Speaker)
    : RecyclerViewCursorAdapter<SingleCategoryListOfWordsAdapter.SingleCategoryWordViewHolder>() {

    override fun onBindViewHolder(viewHolder: SingleCategoryWordViewHolder, cursor: Cursor) {
        val imageObject = ImageObject(cursor)
        viewHolder.itemAnnotation.text = imageObject.annotation
        Picasso.with(context).load(imageObject.imageFile).into(viewHolder.itemImage)
        viewHolder.playButton.setOnClickListener { view ->
            speakAndAnimateButton(imageObject, viewHolder)
        }
    }

    private fun speakAndAnimateButton(imageObject: ImageObject, viewHolder: SingleCategoryWordViewHolder) {
        speaker.speak(
                imageObject.annotation,
                { viewHolder.playButton.post { viewHolder.playButton.progress = 1 } },
                { viewHolder.playButton.post { viewHolder.playButton.progress = 0 } }
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleCategoryWordViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.holder_single_category_list_item, parent, false)
        return SingleCategoryWordViewHolder(itemView)
    }

    class SingleCategoryWordViewHolder : RecyclerView.ViewHolder {
        val itemAnnotation: TextView
        val itemImage: ImageView
        val playButton: ActionProcessButton

        constructor(view : View) : super(view) {
            itemAnnotation = view.findViewById(R.id.itemName) as TextView
            itemImage = view.findViewById(R.id.itemImage) as ImageView
            playButton = view.findViewById(R.id.playButton) as ActionProcessButton
            playButton.setMode(ActionProcessButton.Mode.ENDLESS)
        }
    }
}
