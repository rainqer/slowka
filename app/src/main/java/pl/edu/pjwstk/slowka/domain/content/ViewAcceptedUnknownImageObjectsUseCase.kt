package pl.edu.pjwstk.slowka.domain.content

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.UseCase

class ViewAcceptedUnknownImageObjectsUseCase : UseCase<Cursor> {

    private val imageObjectRepository: ImageObjectRepository

    constructor(imageObjectRepository: ImageObjectRepository) {
        this.imageObjectRepository = imageObjectRepository
    }

    override fun perform(): Cursor {
        return imageObjectRepository.getAllAcceptedUnknown()
    }

}
