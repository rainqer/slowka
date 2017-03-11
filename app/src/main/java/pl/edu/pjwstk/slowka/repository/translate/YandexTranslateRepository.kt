package pl.edu.pjwstk.slowka.repository.translate

import pl.edu.pjwstk.slowka.domain.translate.TranslateRepository
import rx.Observable

class YandexTranslateRepository(private val yandexService: YandexService): TranslateRepository {

    override fun translate(text: String): Observable<String> {
        return yandexService
                .translate(text, "pl", "trnsl.1.1.20170311T105832Z.9c1b69432a44f46a.44187d07169b9a9c41592ea1f12147ba4aac2fde")
                .map { result -> result.translation?.firstOrNull()?:"no translation" }
    }
}
