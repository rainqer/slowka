package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.dd.processbutton.iml.ActionProcessButton
import com.infullmobile.android.recyclerviewwithdynamicsubtitles.DynamicRecyclerViewAdapter
import com.infullmobile.android.recyclerviewwithdynamicsubtitles.SectionEvaluator
import com.squareup.picasso.Picasso
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.presentation.speech.Speaker

class SingleCategoryListOfWordsAdapter (private val context: Context,
                                        private val speaker: Speaker)
    : DynamicRecyclerViewAdapter<
        SingleCategoryListOfWordsAdapter.SingleCategoryWordViewHolder,
        SingleCategoryListOfWordsAdapter.TitleViewHolder,
        ImageObject
        >() {

    private val knownWordsTitle = context.getString(R.string.words_list_known)
    private val unknownWordsTitle = context.getString(R.string.words_list_unknown)

    fun setData(items: Collection<ImageObject>?) {
        super.setData(items, SectionEvaluator { imageObject ->  if(imageObject.known) knownWordsTitle else unknownWordsTitle })
    }
    override fun onCreateViewHolder(parent: ViewGroup): SingleCategoryWordViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.holder_single_category_list_item, parent, false)
        return SingleCategoryWordViewHolder(itemView)
    }

    override fun onCreateTitleViewHolder(parent: ViewGroup): TitleViewHolder {
        val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.holder_sub_title, parent, false)
        return TitleViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: SingleCategoryWordViewHolder, imageObject: ImageObject) {
        viewHolder.itemAnnotation.text = imageObject.annotation
        Picasso.with(context).load(imageObject.imageFile).into(viewHolder.itemImage)
        viewHolder.playButton.setOnClickListener { view ->
            speakAndAnimateButton(imageObject, viewHolder)
        }
    }

    override fun onBindTitleViewHolder(titleViewHolder: TitleViewHolder,
                                       sectionName: String,
                                       dataItems: MutableCollection<ImageObject>) {
        titleViewHolder.title.text = sectionName
    }

    private fun speakAndAnimateButton(imageObject: ImageObject, viewHolder: SingleCategoryWordViewHolder) {
        speaker.speak(
                imageObject.annotation,
                { viewHolder.playButton.post { viewHolder.playButton.progress = 1 } },
                { viewHolder.playButton.post { viewHolder.playButton.progress = 0 } }
        )
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

    class TitleViewHolder : RecyclerView.ViewHolder {
        val title: TextView

        constructor(view : View) : super(view) {
            title = view.findViewById(R.id.titleText) as TextView
        }
    }
}
