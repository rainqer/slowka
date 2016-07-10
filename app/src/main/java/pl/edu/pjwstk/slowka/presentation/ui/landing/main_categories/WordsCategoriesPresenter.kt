package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter

class WordsCategoriesPresenter(private val wordsCategoriesModel: WordsCategoriesModel) : FragmentPresenter<WordsCategoriesView>() {

    override fun onViewCreated() {
        wordsCategoriesModel.getAllCategories().subscribe() { cursor ->
            presentedView.getMainCategoriesGrid()
                    .setAdapter(MainGridCategoryAdapter(presentedActivity, cursor, false))
        }

    }

    override fun onDestroyView() {
        presentedView.getMainCategoriesGrid().setAdapter(null)
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        //NO OP
    }
}
