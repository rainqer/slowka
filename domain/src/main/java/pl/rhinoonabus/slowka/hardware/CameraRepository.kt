package pl.rhinoonabus.slowka.hardware

import rx.Observable

interface CameraRepository {

    fun observeFrames() : Observable<ByteArray>
    fun stop()
    fun obtainPrevier() : Previewer
}
