package pl.edu.pjwstk.slowka.presentation.ui.admin_image_details

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.view.View
import android.widget.EditText
import android.widget.GridView
import android.widget.ImageView
import butterknife.bindView
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.tools.BitmapDecoder
import pl.edu.pjwstk.slowka.presentation.dagger.HasComponent
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaActivity
import pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.dagger.AdminImageDetailsActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.dagger.AdminImageDetailsActivityComponentAssembler
import pl.edu.pjwstk.slowka.presentation.ui.recognize.dagger.RecognizeImageActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.recognize.dagger.RecognizeImageActivityComponentAssembler
import java.io.File
import javax.inject.Inject

class AdminImageDetailsActivity : SlowkaActivity<AdminImageDetailsActivityView>(),
        AdminImageDetailsActivityView,
        HasComponent<AdminImageDetailsActivityComponent?> {

    @Inject
    protected lateinit var presenter: AdminImageDetailsActivityPresenter

    override var component: AdminImageDetailsActivityComponent? = null
    override val activityPresenter: ActivityPresenter<AdminImageDetailsActivityView>
        get() = presenter

    override val imageAnnotation: String
        get() = imageEditableAnnotation.text.toString()

    private val imageEditableAnnotation: EditText by bindView(R.id.annotationForImageContent)
    private val image: ImageView by bindView(R.id.image)
    private val categoryGrid: GridView by bindView(R.id.categoryGrid)
    private val progressBar: View by bindView(R.id.progressBar)
    private val confirmButton: FloatingActionButton by bindView(R.id.fab)

    private var categoryAdapter : CategoryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbar(R.layout.activity_recognizeimage)
        setDaggerComponent(AdminImageDetailsActivityComponentAssembler.assemble(application))
    }

    private fun setDaggerComponent(component: AdminImageDetailsActivityComponent) {
        this.component = component
        this.component?.inject(this)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        attachPresenter(this, this, savedInstanceState)
        confirmButton.setOnClickListener {
            presenter.confirmButtonClicked()
        }
    }

    override fun showImageObject(imageObject: ImageObject) {
        imageEditableAnnotation.setText(imageObject.annotation)
        image.setImageBitmap(BitmapDecoder(imageObject.imageFile).decode())
        hideProgressBar()
    }

    override fun applyCategoryAdapter(newCategoryAdapter: CategoryAdapter) {
        categoryAdapter = newCategoryAdapter
        categoryGrid.setAdapter(categoryAdapter);
        categoryGrid.setOnItemClickListener { adapterView, view, position, l ->
            categoryAdapter?.selected = position
            categoryAdapter?.notifyDataSetChanged()
        }
    }

    override fun getSelectedCategory(): String {
        return categoryAdapter!!.getSelectedCategory().name
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    companion object {
        final val IMAGE_OBJECT_NAME_KEY : String = "imageObjectNameKey"
        fun createIntent(context: Context, id : Int): Intent {
            return Intent(context, AdminImageDetailsActivity::class.java)
                    .putExtra(IMAGE_OBJECT_NAME_KEY, id)
        }
    }
}