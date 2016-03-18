package pl.edu.pjwstk.domain.information

import java.io.File

interface NamesForObjectInImageRepository {
    fun getNamesFor(file: File) : Array<String>
}
