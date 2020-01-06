package info.touret.musicquote.dto


data class MusicQuoteDTO(val author: String, val quote: String) {
    constructor() : this("", "")
}