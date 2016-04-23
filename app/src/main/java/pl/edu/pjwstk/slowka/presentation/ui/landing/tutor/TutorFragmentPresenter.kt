package pl.edu.pjwstk.slowka.presentation.ui.landing.tutor

import pl.edu.pjwstk.slowka.presentation.ui.FragmentPresenter

class TutorFragmentPresenter : FragmentPresenter<TutorFragmentView>() {

    override fun onViewCreated() {
        presentedView.getViewPager()
                .setAdapter(TutorListsPagerAdapter(presentedView.getChildFragmentManager()))
    }

    override fun onDestroyView() {
        presentedView.getViewPager().setAdapter(null)
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        //NO OP
    }
}
