package info.touret.musicquote.service

import info.touret.musicquote.model.MusicQuote
import info.touret.musicquote.repository.MusicQuoteRepository
import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.Mockito

@QuarkusTest
open class MusicQuoteServiceTest {

    @Test
    fun should_get_a_music_quote() {
        val musicQuoteRepository = Mockito.mock(MusicQuoteRepository::class.java)
        val musicQuote = MusicQuote(1, "quoteAuthor", "quoteContent")
        var musicQuoteService = MusicQuoteService(musicQuoteRepository)
        Mockito.`when`(musicQuoteRepository.findARandomMusicQuote()).thenReturn(musicQuote)
        val quote = musicQuoteService.findMusicQuote()
        assertNotNull(quote);
        assertEquals("quoteAuthor", quote.author)
    }
}