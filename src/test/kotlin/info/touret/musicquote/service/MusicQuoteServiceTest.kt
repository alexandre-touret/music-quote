package info.touret.musicquote.service

import info.touret.musicquote.model.MusicQuote
import info.touret.musicquote.repository.MusicQuoteRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito

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

    @Test
    fun should_get_a_list(){
        val musicQuoteRepository = Mockito.mock(MusicQuoteRepository::class.java)
        val musicQuote = MusicQuote(1, "quoteAuthor", "quoteContent")
        val list = listOf(musicQuote)
        Mockito.`when`(musicQuoteRepository.findAllQuotes()).thenReturn(list)
        var musicQuoteService = MusicQuoteService(musicQuoteRepository)
        val quoteList = musicQuoteService.findMusicQuoteList();
        assertNotNull(quoteList)
        assertEquals(1,quoteList.size)
    }
}