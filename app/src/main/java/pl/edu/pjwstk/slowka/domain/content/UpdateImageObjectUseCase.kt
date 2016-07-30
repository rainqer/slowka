package pl.edu.pjwstk.slowka.domain.content

import pl.edu.pjwstk.slowka.domain.UseCase

class UpdateImageObjectUseCase : UseCase<Boolean> {

    private val imageObjectRepository: ImageObjectRepository
    private val imageObject: ImageObject?
    private val imageObjectId: Int?

    constructor(imageObjectRepository: ImageObjectRepository) : this (imageObjectRepository, null, null)

    private constructor(imageObjectRepository: ImageObjectRepository,
                        imageObjectId: Int?,
                        imageObject: ImageObject?) {

        this.imageObjectRepository = imageObjectRepository
        this.imageObject = imageObject
        this.imageObjectId = imageObjectId
    }

    fun id(objectId: Int) : UpdateImageObjectUseCase {
        return UpdateImageObjectUseCase(imageObjectRepository, objectId, imageObject)
    }

    fun imageObject(imageObject: ImageObject) : UpdateImageObjectUseCase {
        return UpdateImageObjectUseCase(imageObjectRepository, imageObjectId, imageObject)
    }

    override fun perform(): Boolean {
        if (imageObjectId == null) {
            throw AssertionError("Image Object id not specified")
        }
        if (imageObject == null) {
            throw AssertionError("Image Object not specified")
        }
        return imageObjectRepository.edit(imageObjectId.toString(), imageObject)
    }

}
