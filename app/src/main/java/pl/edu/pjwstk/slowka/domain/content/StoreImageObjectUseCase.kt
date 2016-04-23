package pl.edu.pjwstk.slowka.domain.content

import pl.edu.pjwstk.slowka.domain.UseCase

class StoreImageObjectUseCase : UseCase<Boolean> {

    private val imageObjectRepository: ImageObjectRepository
    private val imageObject: ImageObject?

    constructor(imageObjectRepository: ImageObjectRepository) : this (imageObjectRepository, null)

    private constructor(imageObjectRepository: ImageObjectRepository,
                        imageObject: ImageObject?) {

        this.imageObjectRepository = imageObjectRepository
        this.imageObject = imageObject
    }

    fun image(imageObject: ImageObject) : StoreImageObjectUseCase {
        return StoreImageObjectUseCase(imageObjectRepository, imageObject)
    }

    override fun perform(): Boolean {
        if (imageObject == null) {
            throw AssertionError("Image Object not specified")
        }
        return imageObjectRepository.insert(imageObject)
    }

}
