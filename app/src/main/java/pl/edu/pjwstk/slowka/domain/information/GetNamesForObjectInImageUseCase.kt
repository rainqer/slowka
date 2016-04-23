package pl.edu.pjwstk.slowka.domain.information

import pl.edu.pjwstk.slowka.domain.UseCase
import java.io.File

class GetNamesForObjectInImageUseCase : UseCase<Array<String>> {

    private val namesForObjectInImageRepository: NamesForObjectInImageRepository
    private val file: File?

    constructor(namesForObjectInImageRepository: NamesForObjectInImageRepository) : this(namesForObjectInImageRepository, null)

    private constructor(namesForObjectInImageRepository: NamesForObjectInImageRepository, file: File?) {
        this.namesForObjectInImageRepository = namesForObjectInImageRepository
        this.file = file
    }

    fun inImageFrom(file: File) : GetNamesForObjectInImageUseCase {
        return GetNamesForObjectInImageUseCase(namesForObjectInImageRepository, file)
    }

    override fun perform(): Array<String> {
        if (file == null) {
            throw AssertionError("Preview must be performed on non null surface holder")
        }
        return namesForObjectInImageRepository.getNamesFor(file)
    }
}
