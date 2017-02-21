package pl.edu.pjwstk.slowka.presentation.ui.single_category

import pl.edu.pjwstk.slowka.presentation.ui.ActivityPresenter
import rx.Subscription
import rx.subscriptions.Subscriptions

class SingleCategoryActivityPresenter()
    : ActivityPresenter<SingleCategoryActivityView>() {

    private var refreshListSubscription : Subscription = Subscriptions.unsubscribed()

    override fun resume() {
        presentedView.getViewPager().adapter = SingleCategoryListsPagerAdapter(presentedView.getSupportFragmentManager(), presentedActivity)
        presentedView.getWordsListTabs().setupWithViewPager(presentedView.getViewPager())
    }

    override fun pause() {
        refreshListSubscription.unsubscribe()
    }

    override fun onRequestPermissionsResult(requestCode: Int, grantResults: IntArray) {
    }

    companion object {
        val CATEGORY_NAME_KEY = "categoryNameKey"
    }
}
