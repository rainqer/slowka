package pl.edu.pjwstk.slowka.repository

import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.content.ImageObjectRepository
import pl.edu.pjwstk.slowka.domain.test.TestRepository
import pl.edu.pjwstk.slowka.domain.test.TestResult

class LocalMemoryTestRepository(private val imageObjectRepository: ImageObjectRepository) : TestRepository {

    private var imageObjects: MutableList<ImageObject> = mutableListOf()
    private var imageObjectsWithAnswers: MutableList<Pair<ImageObject, String>> = mutableListOf()

    override fun startNewTestForCategory(category: Category): Boolean {
        imageObjects.clear()
        val allImagesFromCategoryCursor = imageObjectRepository.getAcceptedImagesInCategory(category.name)
        while(allImagesFromCategoryCursor.moveToNext()) {
            val imageObject = ImageObject(allImagesFromCategoryCursor)
            if (!imageObject.known) {
                imageObjects.add(imageObject)
            }
        }
        return imageObjects.isNotEmpty()
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

    override fun finishCurrentTest(): TestResult {
        val testResults = countResultsAndMarkCorrectAsKnown()
        imageObjects.clear()
        imageObjectsWithAnswers.clear()
        return testResults
    }

    private fun countResultsAndMarkCorrectAsKnown(): TestResult {
        var correctAnswers = 0
        var incorrectAnswers = 0
        for ((imageObject, answer) in imageObjectsWithAnswers) {
            if (imageObject.annotation == answer) {
                imageObjectRepository.markAsKnown(imageObject.objectId?:throw IllegalStateException("this object has no id"))
                ++correctAnswers
            } else {
                ++incorrectAnswers
            }
        }
        return TestResult(correctAnswers, incorrectAnswers)
    }
}
