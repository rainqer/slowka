package pl.edu.pjwstk.slowka.repository

import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.content.ImageObjectRepository
import pl.edu.pjwstk.slowka.domain.test.TestRepository

class LocalMemoryTestRepository(private val imageObjectRepository: ImageObjectRepository) : TestRepository {

    private var imageObjects: MutableList<ImageObject> = mutableListOf()
    private var imageObjectsWithAnswers: MutableList<Pair<ImageObject, String>> = mutableListOf()

    override fun startNewTestForCategory(category: Category) {
        imageObjects.clear()
        val allImagesFromCategoryCursor = imageObjectRepository.getAcceptedImagesInCategory(category.name)
        while(allImagesFromCategoryCursor.moveToNext()) {
            imageObjects.add(ImageObject(allImagesFromCategoryCursor))
        }
    }

    override fun startNewTestForImages(ids: Array<Long>) {
    }

    override fun uploadAnswerForImage(imageObject: ImageObject, answer: String): Boolean {
        imageObjects.remove(imageObject)

        imageObjectsWithAnswers.add(Pair(imageObject, answer))

        return imageObjects.isEmpty()
    }

    override fun getNextImageFromCurrentTest(): ImageObject {
        return imageObjects[0]
    }
}
