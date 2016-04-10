package pl.edu.pjwstk.slowka.presentation.presenter.landing.tutor

import android.database.Cursor
import pl.edu.pjwstk.slowka.domain.UseCase
import pl.edu.pjwstk.slowka.domain.content.ViewAllImageObjectsUseCase
import pl.edu.pjwstk.slowka.repository.content.AndroidImageObjectRepository

class IKnowWordsListFragmentPresenter : WordsListFragmentPresenter() {

    override fun LoadImagesUseCase(): UseCase<Cursor>
            = ViewAllImageObjectsUseCase(AndroidImageObjectRepository(presentedActivity))
}
