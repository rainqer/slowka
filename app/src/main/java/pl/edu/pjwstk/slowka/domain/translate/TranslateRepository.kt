package pl.edu.pjwstk.slowka.domain.translate

import rx.Observable

interface TranslateRepository {
    fun translate(text: String): Observable<String>
}
