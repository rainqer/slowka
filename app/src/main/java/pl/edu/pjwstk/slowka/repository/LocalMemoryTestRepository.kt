package pl.edu.pjwstk.slowka.repository

import pl.edu.pjwstk.slowka.domain.content.Category
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.test.TestRepository


class LocalMemoryTestRepository : TestRepository {

    private var imageObjects: Array<ImageObject> = emptyArray()

    override fun startNewTestForCategory(category: Category) {

    }

    override fun startNewTestForImages(ids: Array<Long>) {
    }

    override fun uploadAnswerForImage(answer: String): Boolean {
        return true
    }

    override fun getNextImageFromCurrentTest(): ImageObject {
        return imageObjects[0]
    }
}
