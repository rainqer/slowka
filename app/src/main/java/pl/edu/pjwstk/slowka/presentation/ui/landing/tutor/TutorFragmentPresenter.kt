package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor

import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter

class TutorFragmentPresenter : FragmentPresenter<TutorFragmentView>() {

    override fun onViewCreated() {
        presentedView.getViewPager().adapter = TutorListsPagerAdapter(presentedView.getChildFragmentManager(), presentedActivity)
        presentedView.getWordsListTabs().setupWithViewPager(presentedView.getViewPager())
    }

    override fun onDestroyView() {
        presentedView.getViewPager().adapter = null
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        //NO OP
    }
}
