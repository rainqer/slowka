package pl.edu.pjwstk.slowka.domain.content


interface RecentlyAddedWordRepository {
    fun getRecentWord() : String?
    fun rememberRecentWord(word: String)
}
