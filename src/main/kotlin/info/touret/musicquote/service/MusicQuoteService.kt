package info.touret.musicquote.service

import info.touret.musicquote.model.MusicQuote
import info.touret.musicquote.repository.MusicQuoteRepository
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class MusicQuoteService() {

    @Inject
    @field: ApplicationScoped
    lateinit var musicQuoteRepository: MusicQuoteRepository

    fun findMusicQuote(): MusicQuote {
        return musicQuoteRepository!!.findARandomMusicQuote() ?: MusicQuote()
    }
}