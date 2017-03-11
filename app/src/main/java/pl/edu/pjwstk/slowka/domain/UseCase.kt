package pl.edu.pjwstk.slowka.domain

import rx.Observable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

abstract class UseCase<T> {

    abstract fun perform() : T

    fun performAsync() {
        Observable.fromCallable {
            perform()
        }.subscribeOn(Schedulers.newThread()).subscribe()
    }

    open fun performAndObserve(scheduler: Scheduler) : Observable<T> {
        return Observable.fromCallable {
            perform()
        }
        .subscribeOn(scheduler)
        .observeOn(AndroidSchedulers.mainThread())
    }

    fun performWithoutRedirection() : Observable<T> {
        return Observable.fromCallable {
            perform()
        }
    }
}
