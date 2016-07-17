package pl.edu.pjwstk.slowka.presentation.ui.single_category

import android.widget.Toast
import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter

class SingleCategoryActivityPresenter() : ActivityPresenter<SingleCategoryActivityView>() {

    override fun resume() {
        Toast.makeText(presentedActivity, presentedActivity.intent.getIntExtra(CATEGORY_ID_KEY, -1), Toast.LENGTH_LONG).show()
    }

    override fun pause() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }

    companion object {
        val CATEGORY_ID_KEY = "categoryIdKey"
    }
}
