package pl.edu.pjwstk.slowka.domain.information

import pl.edu.pjwstk.slowka.domain.UseCase
import pl.edu.pjwstk.slowka.domain.translate.TranslateRepository
import rx.Observable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.io.File

class GetNamesForObjectInImageUseCase : UseCase<String> {

    private val namesForObjectInImageRepository: NamesForObjectInImageRepository
    private val translateRepository: TranslateRepository
    private val file: File?

    constructor(namesForObjectInImageRepository: NamesForObjectInImageRepository,
                translateRepository: TranslateRepository)
    : this(namesForObjectInImageRepository, translateRepository, null)

    private constructor(namesForObjectInImageRepository: NamesForObjectInImageRepository,
                        translateRepository: TranslateRepository,
                        file: File?) {
        this.namesForObjectInImageRepository = namesForObjectInImageRepository
        this.translateRepository = translateRepository
        this.file = file
    }

    fun inImageFrom(file: File) : GetNamesForObjectInImageUseCase {
        return GetNamesForObjectInImageUseCase(namesForObjectInImageRepository, translateRepository, file)
    }

    override fun perform(): String {
        if (file == null) {
            throw AssertionError("Preview must be performed on non null surface holder")
        }
        return namesForObjectInImageRepository.getNamesFor(file)[0]
    }

    override fun performAndObserve(scheduler: Scheduler): Observable<String> {
        return Observable
                .fromCallable { perform() }
                .subscribeOn(scheduler)
                .flatMap { annotation ->
                    translateRepository.translate(annotation)
                }
                .subscribeOn(scheduler)
                .observeOn(AndroidSchedulers.mainThread())
    }
}
