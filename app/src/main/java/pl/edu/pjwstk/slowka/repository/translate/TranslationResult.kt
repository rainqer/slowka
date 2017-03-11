package pl.edu.pjwstk.slowka.repository.translate

import com.google.gson.annotations.SerializedName

data class TranslationResult (
        @SerializedName("code") var code: String?,
        @SerializedName("lang") var language: String?,
        @SerializedName("text") var translation: List<String>?
)
