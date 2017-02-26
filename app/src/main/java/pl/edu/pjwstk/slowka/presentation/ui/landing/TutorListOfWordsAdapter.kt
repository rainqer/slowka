package pl.edu.pjwstk.slowka.presentation.ui.landing

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
import pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.AdminImageDetailsActivity
import pl.edu.pjwstk.slowka.presentation.ui.landing.tutor.AdapterItemRestoreToLearningListener
import skyfish.RecyclerViewCursorAdapter

class TutorListOfWordsAdapter (private val context: Context,
                               private val speaker: Speaker)
    : RecyclerViewCursorAdapter<TutorListOfWordsAdapter.TutorWordViewHolder>() {

    var adapterItemRestoreToLearningListener: AdapterItemRestoreToLearningListener? = null
    var shouldShowRestoreButtonInDetails: Boolean = false

    override fun onBindViewHolder(viewHolder: TutorWordViewHolder, cursor: Cursor) {
        val imageObject = ImageObject(cursor)
        viewHolder.itemAnnotation.text = imageObject.annotation
        Picasso.with(context).load(imageObject.imageFile).into(viewHolder.itemImage)
        val context = viewHolder.itemView.context
        viewHolder.itemView.setOnClickListener {
            startImageDetails(context, imageObject)
        }
        viewHolder.editButton.setOnClickListener {
            startImageDetails(context, imageObject)
        }
        viewHolder.playButton.setOnClickListener {
            playSpeechWithAnimation(imageObject.annotation, viewHolder)
        }
    }

    private fun playSpeechWithAnimation(annotation: String, viewHolder: TutorWordViewHolder) {
        speaker.speak(
                annotation,
                { viewHolder.playButton.post { viewHolder.playButton.progress = 1 } },
                { viewHolder.playButton.post { viewHolder.playButton.progress = 0 } }
        )
    }

    private fun startImageDetails(context: Context, imageObject: ImageObject) {
        context.startActivity(AdminImageDetailsActivity
                .createIntent(context, imageObject.objectId!!, shouldShowRestoreButtonInDetails))
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
        val editButton: ActionProcessButton
        val playButton: ActionProcessButton

        constructor(view : View) : super(view) {
            itemAnnotation = view.findViewById(R.id.itemName) as TextView
            itemImage = view.findViewById(R.id.itemImage) as ImageView
            editButton = view.findViewById(R.id.editButton) as ActionProcessButton
            playButton = view.findViewById(R.id.playButton) as ActionProcessButton
            playButton.setMode(ActionProcessButton.Mode.ENDLESS)
        }
    }
}
