package pl.edu.pjwstk.slowka.presentation.speech

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import java.util.*

class Speaker(private val context: Context): UtteranceProgressListener() {

    val speech: TextToSpeech

    var onStart: (()->Unit)? = null

    var onFinish: (()->Unit)? = null

    init {
        speech = TextToSpeech(context, { initStatus -> })
        speech.language = Locale("pl")
        speech.setSpeechRate(0.9f)
    }
    fun speak(textToSpeak: String) {
        speak(textToSpeak, null, null)
    }
    fun speak(textToSpeak: String, onStart: (()->Unit)?, onFinish: (()->Unit)?) {
        finishSpeech()
        this.onStart = onStart
        this.onFinish = onFinish
        speech.setOnUtteranceProgressListener(this)
        speech.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, null, Random().nextInt().toString())
    }

    override fun onStart(utteranceId: String?) {
        onStart?.invoke()
    }

    override fun onError(utteranceId: String?) {
        onFinish?.invoke()
    }

    override fun onDone(utteranceId: String?) {
        onFinish?.invoke()
    }

    private fun finishSpeech() {
        onFinish?.invoke()
        speech.setOnUtteranceProgressListener(null)
        onStart = null
        onFinish = null
    }
}
