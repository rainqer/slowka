package pl.edu.pjwstk.domain.information

import pl.edu.pjwstk.domain.UseCase
import javax.inject.Inject

class GetNamesForObjectInImageUseCase : UseCase<Array<String>> {

    private val namesForObjectInImageRepository: NamesForObjectInImageRepository

    @Inject
    constructor(namesForObjectInImageRepository: NamesForObjectInImageRepository) {
        this.namesForObjectInImageRepository = namesForObjectInImageRepository
    }

    override fun perform(): Array<String> {
        return namesForObjectInImageRepository.getNamesFor()
    }
}
