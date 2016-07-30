package pl.edu.pjwstk.slowka.domain.content

import pl.edu.pjwstk.slowka.domain.UseCase

class GetImageObjectUseCase : UseCase<ImageObject> {

    private val imageObjectRepository: ImageObjectRepository
    private val imageObjectId: Int?

    constructor(imageObjectRepository: ImageObjectRepository) : this (imageObjectRepository, null)

    private constructor(imageObjectRepository: ImageObjectRepository,
                        imageObjectId: Int?) {

        this.imageObjectRepository = imageObjectRepository
        this.imageObjectId = imageObjectId
    }

    fun id(objectId: Int) : GetImageObjectUseCase {
        return GetImageObjectUseCase(imageObjectRepository, objectId)
    }

    override fun perform(): ImageObject {
        if (imageObjectId == null) {
            throw AssertionError("Image Object Id not specified")
        }
        val cursor = imageObjectRepository.get(imageObjectId)
        if (cursor.moveToFirst()) {
            return ImageObject(cursor)
        } else {
            throw IllegalAccessError("No such image object")
        }
    }

}
