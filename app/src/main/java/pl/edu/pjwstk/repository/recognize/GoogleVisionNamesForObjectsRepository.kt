package pl.edu.pjwstk.repository.recognize

import pl.edu.pjwstk.domain.information.NamesForObjectInImageRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoogleVisionNamesForObjectsRepository @Inject constructor() : NamesForObjectInImageRepository {

    override fun getNamesFor(): Array<String> {
        return arrayOf("aaa")
    }
}
