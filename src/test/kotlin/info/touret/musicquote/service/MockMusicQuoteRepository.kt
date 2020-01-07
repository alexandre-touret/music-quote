package info.touret.musicquote.service

import info.touret.musicquote.model.MusicQuote
import info.touret.musicquote.repository.MusicQuoteRepository
import io.quarkus.test.Mock
import javax.enterprise.context.ApplicationScoped

@Mock
@ApplicationScoped
class MockMusicQuoteRepository : MusicQuoteRepository() {
    override fun findARandomMusicQuote(): MusicQuote? {
        return MusicQuote(1, "author", "quote")
    }
}