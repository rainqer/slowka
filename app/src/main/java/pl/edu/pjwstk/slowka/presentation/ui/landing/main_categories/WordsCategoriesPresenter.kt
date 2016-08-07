package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter

class WordsCategoriesPresenter(private val wordsCategoriesModel: WordsCategoriesModel) : FragmentPresenter<WordsCategoriesView>() {

    override fun onViewCreated() {
        wordsCategoriesModel.getAllWords().subscribe() { listOfAllCategoriesWithImageObjectsCount ->
            presentedView.getMainCategoriesList().adapter = MainGridCategoryAdapter(listOfAllCategoriesWithImageObjectsCount)
        }

    }

    override fun onDestroyView() {
        presentedView.getMainCategoriesList().adapter = null
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        //NO OP
    }
}
