package pl.edu.pjwstk.slowka.domain.tools

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DateFileNameGenerator @Inject constructor() {

    fun generate(): String {
        return SimpleDateFormat(DATE_FORMAT)
                .format(Calendar.getInstance().time)
    }

    companion object {
        val DATE_FORMAT = "MM_dd_yyyy_HH_mm_ss"
    }
}
