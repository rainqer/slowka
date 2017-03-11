package pl.edu.pjwstk.slowka.repository.content

import pl.edu.pjwstk.slowka.domain.content.RecentlyAddedWordRepository

class VolatileRecentlyAddedWordRepository : RecentlyAddedWordRepository {

    private var recentWord: String? = null

    override fun getRecentWord(): String? {
        val word = recentWord
        recentWord = null
        return word
    }

    override fun rememberRecentWord(word: String) {
        recentWord = word
    }
}
