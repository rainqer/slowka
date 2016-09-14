package pl.edu.pjwstk.slowka.presentation.ui.landing.tests

import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter

class SelectTestsFragmentPresenter (private val availableTestsModel: SelectTestsModel)
: FragmentPresenter<SelectTestsFragmentView>() {

    override fun onViewCreated() {
        availableTestsModel.getAllWords().subscribe { listOfCategoriesWithWordsCount ->
            presentedView.getAvailableTestsView().adapter = AvailableTestsAdapter(listOfCategoriesWithWordsCount)
        }
    }

    override fun onDestroyView() {
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        //NO OP
    }
}
