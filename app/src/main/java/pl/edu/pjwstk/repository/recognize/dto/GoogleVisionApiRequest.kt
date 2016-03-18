package pl.edu.pjwstk.repository.recognize.dto

class GoogleVisionApiRequest {
    var image : Image? = null
    var features : Array<Feature> = emptyArray()
}
