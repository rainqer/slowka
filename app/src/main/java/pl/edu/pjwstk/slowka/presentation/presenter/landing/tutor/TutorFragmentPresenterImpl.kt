package pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor

class TutorFragmentPresenterImpl : TutorFragmentPresenter() {

    override fun onViewCreated() {
        presentedView.getViewPager()
                .setAdapter(TutorListsPagerAdapter(presentedActivity.supportFragmentManager))
    }

    override fun onDestroy() {
        presentedView.getViewPager().setAdapter(null)
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
        //NO OP
    }
}
