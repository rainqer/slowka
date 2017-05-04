package pl.edu.pjwstk.slowka.presentation.ui.admin_image_details

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.widget.CursorAdapter
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.EditText
import android.widget.GridView
import android.widget.ImageView
import android.widget.Spinner
import butterknife.bindView
import com.dd.processbutton.iml.ActionProcessButton
import pl.edu.pjwstk.slowka.R
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.tools.Galery
import pl.edu.pjwstk.slowka.presentation.dagger.HasComponent
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import pl.edu.pjwstk.slowka.presentation.ui.SlowkaActivity
import pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.dagger.AdminImageDetailsActivityComponent
import pl.edu.pjwstk.slowka.presentation.ui.admin_image_details.dagger.AdminImageDetailsActivityComponentAssembler
import pl.edu.pjwstk.slowka.presentation.ui.single_category.SingleCategoryActivityPresenter
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
    private val restoreButton: ActionProcessButton by bindView(R.id.restoreButton)
    private val image: ImageView by bindView(R.id.image)
    private val categorySpinner: Spinner by bindView(R.id.categorySpinner)
    private val progressBar: View by bindView(R.id.progressBar)
    private val confirmButton: FloatingActionButton by bindView(R.id.fab)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithToolbar(R.layout.activity_recognizeimage)
        setDaggerComponent(AdminImageDetailsActivityComponentAssembler.assemble(application))
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.title = getString(R.string.title)
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
        restoreButton.setOnClickListener {
            presenter.restoreButtonClicked()
        }
    }

    override fun showImageObject(imageObject: ImageObject) {
        imageEditableAnnotation.setText(imageObject.annotation)
        image.setImageBitmap(Galery(this).getScaledDownImage(imageObject.imageFile))
        hideProgressBar()
    }

    override fun applyCategoryAdapter(cursorAdapter: CursorAdapter) {
        categorySpinner.adapter = cursorAdapter
    }

    override fun getSelectedCategory(): String {
        return (categorySpinner.selectedItem  as Cursor).getString(1)
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun setRestoreButtonVisibility(shouldShowRestoreButton: Boolean) {
        restoreButton.visibility = if (shouldShowRestoreButton) View.VISIBLE else View.GONE
    }

    companion object {
        val IMAGE_OBJECT_NAME_KEY : String = "imageObjectNameKey"
        val SHOULD_SHOW_RESTORE_KEY : String = "shouldShowRestoreKey"
        fun createIntent(context: Context, id : Int, boolean: Boolean): Intent {
            return Intent(context, AdminImageDetailsActivity::class.java)
                    .putExtra(IMAGE_OBJECT_NAME_KEY, id)
                    .putExtra(SHOULD_SHOW_RESTORE_KEY, boolean)
        }
    }
}
