package pl.edu.pjwstk.slowka.presentation.speech

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import java.util.*

class Speaker(private val context: Context) {

    val speech: TextToSpeech

    init {
        speech = TextToSpeech(context, { initStatus -> })
        speech.language = Locale("pl")
        speech.setSpeechRate(0.8f)
    }

    fun speak(textToSpeak: String) {
        speak(textToSpeak, null, null)
    }

    fun speak(textToSpeak: String, onStart: (()->Unit)?, onFinish: (()->Unit)?) {
        speech.setOnUtteranceProgressListener(object: UtteranceProgressListener() {

            override fun onDone(utteranceId: String?) {
                onFinish?.invoke()
                speech.setOnUtteranceProgressListener(null)
            }

            override fun onError(utteranceId: String?) { }

            override fun onStart(utteranceId: String?) {
                onStart?.invoke()
            }
        })
        speech.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, null, Random().nextInt().toString())
    }

}
