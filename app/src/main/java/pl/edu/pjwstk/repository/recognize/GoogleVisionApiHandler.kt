package pl.edu.pjwstk.repository.recognize

import retrofit.ErrorHandler
import retrofit.RetrofitError
import javax.inject.Inject
import javax.inject.Singleton

//TODO handle properly
@Singleton
class GoogleVisionApiHandler @Inject constructor(): ErrorHandler {
    override fun handleError(error: RetrofitError?): Throwable? {
        return error
    }
}
