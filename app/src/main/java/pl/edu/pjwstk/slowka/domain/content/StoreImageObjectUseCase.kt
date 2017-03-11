package pl.edu.pjwstk.slowka.domain.content

import pl.edu.pjwstk.slowka.domain.UseCase

class StoreImageObjectUseCase : UseCase<Boolean> {

    private val imageObjectRepository: ImageObjectRepository
    private val recentlyAddedWordRepository: RecentlyAddedWordRepository
    private val imageObject: ImageObject?

    constructor(imageObjectRepository: ImageObjectRepository, recentlyAddedWordRepository: RecentlyAddedWordRepository)
        : this (imageObjectRepository, recentlyAddedWordRepository, null)

    private constructor(imageObjectRepository: ImageObjectRepository,
                        recentlyAddedWordRepository: RecentlyAddedWordRepository,
                        imageObject: ImageObject?) {

        this.imageObjectRepository = imageObjectRepository
        this.recentlyAddedWordRepository = recentlyAddedWordRepository
        this.imageObject = imageObject
    }

    fun image(imageObject: ImageObject) : StoreImageObjectUseCase {
        return StoreImageObjectUseCase(imageObjectRepository, recentlyAddedWordRepository, imageObject)
    }

    override fun perform(): Boolean {
        if (imageObject == null) {
            throw AssertionError("Image Object not specified")
        }
        return imageObjectRepository.insert(imageObject).apply {
            if (this) recentlyAddedWordRepository.rememberRecentWord(imageObject.annotation)
        }
    }
}
