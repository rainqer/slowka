package pl.edu.pjwstk.slowka.domain.test

import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.domain.content.ImageObject

interface TestRepository {
    fun startNewTestForCategory(category: Category): Boolean
    fun startNewTestForImages(ids: Array<Long>)
    fun uploadAnswerForImage(imageObject: ImageObject, answer: String): Boolean
    fun getNextImageFromCurrentTest(): ImageObject
    fun finishCurrentTest(): TestResult
}
