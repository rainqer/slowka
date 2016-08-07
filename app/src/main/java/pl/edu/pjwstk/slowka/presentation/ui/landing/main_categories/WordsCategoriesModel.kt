package pl.edu.pjwstk.slowka.presentation.ui.landing.main_categories

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.content.CategoryWithWords
import pl.edu.pjwstk.slowka.domain.content.ImageObject
import pl.edu.pjwstk.slowka.domain.content.ViewAllCategoriesUseCase
import pl.edu.pjwstk.slowka.domain.content.ViewAllImageObjectsUseCase
import rx.Observable
import rx.functions.Func2

class WordsCategoriesModel (private val viewAllImageObjectsUseCase: ViewAllImageObjectsUseCase,
                            private val viewAllImageCategoriesUseCase: ViewAllCategoriesUseCase) {

    fun getAllWords() : Observable<List<CategoryWithWords>> {
        return viewAllImageCategoriesUseCase
                .performWithoutRedirection()
                .map { cursor -> toMapOfCategoriesWithWords(cursor)}
                .zipWith (viewAllImageObjectsUseCase.performWithoutRedirection(), getImageObjectsCounter())

    }

    private fun toMapOfCategoriesWithWords(cursor: Cursor): Map<String, CategoryWithWords> {
        val mapOfCategoriesWithWords = mutableMapOf<String, CategoryWithWords>()
        if (cursor.moveToFirst()) {
            do {
                val categoryWithWords = CategoryWithWords(cursor)
                mapOfCategoriesWithWords.put(categoryWithWords.category.name, categoryWithWords)
            } while (cursor.moveToNext())
        }
        return mapOfCategoriesWithWords
    }

    private fun getImageObjectsCounter(): Func2<Map<String, CategoryWithWords>, Cursor, List<CategoryWithWords>> {
        return Func2 { listOfCategoriesWithWords, cursorOfImageObjects -> countImageObjects(listOfCategoriesWithWords, cursorOfImageObjects) }
    }

    private fun countImageObjects(mapOfCategoriesWithWords: Map<String, CategoryWithWords>,
                                  cursorOfImageObjects: Cursor)
            : List<CategoryWithWords> {

        if (cursorOfImageObjects.moveToFirst()) {
            do {
                val imageObject = ImageObject(cursorOfImageObjects)
                mapOfCategoriesWithWords[imageObject.categoryName]?.incNotKnown()
            } while (cursorOfImageObjects.moveToNext())
        }
        return mapOfCategoriesWithWords.values.toList()
    }
}
