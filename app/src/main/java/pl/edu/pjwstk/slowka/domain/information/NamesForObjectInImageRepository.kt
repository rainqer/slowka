package pl.edu.pjwstk.slowka.domain.information

import java.io.File

interface NamesForObjectInImageRepository {
    fun getNamesFor(file: File) : Array<String>
}
