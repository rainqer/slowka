package pl.edu.pjwstk.domain

import rx.Observable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

abstract class UseCase<T> {

    abstract fun perform() : T

    fun performAsync() {
        performAndObserve().subscribeOn(Schedulers.newThread()).subscribe()
    }

    fun performAndObserve() :Observable<T> {
        return Observable.fromCallable {
            perform()
        }
    }

    fun performAndObserve(scheduler: Scheduler) :Observable<T> {
        return Observable.fromCallable {
            perform()
        }
        .subscribeOn(scheduler)
        .observeOn(AndroidSchedulers.mainThread())
    }
}
