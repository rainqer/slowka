package pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor

class TutorFragmentPresenterImpl : TutorFragmentPresenter() {

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
