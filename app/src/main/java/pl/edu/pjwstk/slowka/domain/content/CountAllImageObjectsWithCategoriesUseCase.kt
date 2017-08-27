package pl.edu.pjwstk.slowka.domain.content

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.AgregatingUseCase
import rx.Observable
import rx.functions.Func2

class CountAllImageObjectsWithCategoriesUseCase(
        private val viewAllImageObjectsUseCase: ViewAllImageObjectsUseCase,
        private val viewAllImageCategoriesUseCase: ViewAllCategoriesUseCase
) : AgregatingUseCase<List<CategoryWithWords>>() {

    override fun perform(): Observable<List<CategoryWithWords>> {
        return viewAllImageCategoriesUseCase
                .performWithoutRedirection()
                .map { cursor -> toMapOfCategoriesWithWords(cursor)}
                .zipWith (viewAllImageObjectsUseCase.performWithoutRedirection(), getImageObjectsCounter())
    }

    private fun toMapOfCategoriesWithWords(cursor: Cursor): Map<Int, CategoryWithWords> {
        val mapOfCategoriesWithWords = mutableMapOf<Int, CategoryWithWords>()
        if (cursor.moveToFirst()) {
            do {
                val categoryWithWords = CategoryWithWords(cursor)
                mapOfCategoriesWithWords.put(categoryWithWords.category.name, categoryWithWords)
            } while (cursor.moveToNext())
        }
        return mapOfCategoriesWithWords
    }

    private fun getImageObjectsCounter(): Func2<Map<Int, CategoryWithWords>, Cursor, List<CategoryWithWords>> {
        return Func2 { listOfCategoriesWithWords, cursorOfImageObjects -> countImageObjects(listOfCategoriesWithWords, cursorOfImageObjects) }
    }

    private fun countImageObjects(mapOfCategoriesWithWords: Map<Int, CategoryWithWords>,
                                  cursorOfImageObjects: Cursor)
            : List<CategoryWithWords> {

        if (cursorOfImageObjects.moveToFirst()) {
            do {
                val imageObject = ImageObject(cursorOfImageObjects)
                if (imageObject.accepted) {
                    if (imageObject.known) {
                        mapOfCategoriesWithWords[imageObject.categoryName]?.incKnown()
                    } else {
                        mapOfCategoriesWithWords[imageObject.categoryName]?.incNotKnown()
                    }
                }
            } while (cursorOfImageObjects.moveToNext())
        }
        return mapOfCategoriesWithWords.values.toList()
    }

}
