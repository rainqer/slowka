package pl.edu.pjwstk.repository.recognize

import retrofit.ErrorHandler
import retrofit.RetrofitError

//TODO handle properly
class GoogleVisionApiHandler : ErrorHandler {
    override fun handleError(error: RetrofitError?): Throwable? {
        return error
    }
}
