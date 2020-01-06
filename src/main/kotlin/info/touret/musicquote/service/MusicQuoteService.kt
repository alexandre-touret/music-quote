package info.touret.musicquote.service

import info.touret.musicquote.model.MusicQuote
import info.touret.musicquote.repository.MusicQuoteRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MusicQuoteService(var musicQuoteRepository: MusicQuoteRepository) {

    fun findMusicQuote(): MusicQuote {
        return musicQuoteRepository.findARandomMusicQuote() ?: MusicQuote()
    }
}