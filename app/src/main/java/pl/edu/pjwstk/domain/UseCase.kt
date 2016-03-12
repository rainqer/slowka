package pl.edu.pjwstk.domain

import rx.Observable

abstract class UseCase<T> {
    abstract fun perform() : Observable<T>

    fun performSync() {
        perform().subscribe()
    }
}
