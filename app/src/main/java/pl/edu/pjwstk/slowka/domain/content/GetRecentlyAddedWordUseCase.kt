package pl.edu.pjwstk.slowka.domain.content

import pl.edu.pjwstk.slowka.domain.UseCase

class GetRecentlyAddedWordUseCase(private val recentlyAddedWordRepository: RecentlyAddedWordRepository)
    : UseCase<String?>() {

    override fun perform(): String? {
        return recentlyAddedWordRepository.getRecentWord()
    }
}
