package pl.edu.pjwstk.slowka.presentation.ui.landing.tests

import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter
import pl.edu.pjwstk.slowka.presentation.ui.tests.TestSingleImageActivity

class SelectTestsFragmentPresenter (private val availableTestsModel: SelectTestsModel)
    : FragmentPresenter<SelectTestsFragmentView>(), OnCategoryForTestSelectedListener {

    override fun onViewCreated() {
    }

    fun resume() {
        availableTestsModel.getAllWords().subscribe { listOfCategoriesWithWordsCount ->
            presentedView.getAvailableTestsView().adapter = AvailableTestsAdapter(this, listOfCategoriesWithWordsCount)
        }
    }

    override fun onDestroyView() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        //NO OP
    }

    override fun onCategoryForTestSelected(category: Category) {
        availableTestsModel.startTestForCategory(category).subscribe {
            presentedActivity.startActivity(TestSingleImageActivity.createIntent(presentedActivity))
        }
    }
}
