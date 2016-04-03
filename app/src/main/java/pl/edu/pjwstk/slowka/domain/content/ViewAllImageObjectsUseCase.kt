package pl.edu.pjwstk.slowka.domain.content

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.UseCase
import javax.inject.Inject

class ViewAllImageObjectsUseCase : UseCase<Cursor> {

    private val imageObjectRepository: ImageObjectRepository

    @Inject
    constructor(imageObjectRepository: ImageObjectRepository) {

        this.imageObjectRepository = imageObjectRepository
    }

    override fun perform(): Cursor {
        return imageObjectRepository.getAll()
    }

}
