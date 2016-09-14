package pl.edu.pjwstk.slowka.domain

import rx.Observable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

abstract class AgregatingUseCase<T> {

    abstract fun perform() : Observable <T>

    fun performAsync() {
        perform().subscribeOn(Schedulers.newThread()).subscribe()
    }

    fun performAndObserve(scheduler: Scheduler) : Observable<T> {
        return perform()
                .subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun performWithoutRedirection() : Observable<T> {
       return perform()
    }
}
