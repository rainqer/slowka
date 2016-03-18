package pl.edu.pjwstk.presentation.presenter.recognize

import pl.edu.pjwstk.presentation.model.recognize.RecognizeImageModel

class RecognizeImageActivityPresenterImpl constructor(
        val recognizeImageActivityModel: RecognizeImageModel
    ) : RecognizeImageActivityPresenter() {

    override fun resume() {
        recognizeImageActivityModel.recognizeObjectInImage()
    }

    override fun pause() {
    }

}
