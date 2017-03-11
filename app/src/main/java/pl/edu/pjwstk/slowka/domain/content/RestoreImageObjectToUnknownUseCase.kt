package pl.edu.pjwstk.slowka.domain.content

import pl.edu.pjwstk.slowka.domain.UseCase

class RestoreImageObjectToUnknownUseCase : UseCase<Boolean> {

    private val imageObjectRepository: ImageObjectRepository
    private val imageObjectId: Int?

    constructor(imageObjectRepository: ImageObjectRepository) : this (imageObjectRepository, null)

    private constructor(imageObjectRepository: ImageObjectRepository,
                        imageObjectId: Int?) {

        this.imageObjectRepository = imageObjectRepository
        this.imageObjectId = imageObjectId
    }

    fun imageObjectId(imageObjectId: Int) : RestoreImageObjectToUnknownUseCase {
        return RestoreImageObjectToUnknownUseCase(imageObjectRepository, imageObjectId)
    }

    override fun perform(): Boolean {
        if (imageObjectId == null) {
            throw AssertionError("Image Object Id not specified")
        }
        return imageObjectRepository.markAsUnknown(imageObjectId)
    }
}
