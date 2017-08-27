package pl.edu.pjwstk.slowka.repository.recognize

import pl.edu.pjwstk.slowka.domain.information.NamesForObjectInImageRepository
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockNamesForObjectsRepository @Inject constructor() : NamesForObjectInImageRepository {

    override fun getNamesFor(file: File): Array<String> {
        return arrayOf("kubek", "clay", "red stuff")
    }
}
