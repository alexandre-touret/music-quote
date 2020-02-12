package info.touret.musicquote.resource

import info.touret.musicquote.dto.MusicQuoteDTO
import info.touret.musicquote.service.MusicQuoteService
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/music-quote")
class MusicQuoteResource(@Inject var musicQuoteService: MusicQuoteService) {

    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    fun showRandomQuote(): MusicQuoteDTO {
        val quote = musicQuoteService.findMusicQuote();
        return MusicQuoteDTO(quote.author ?: "", quote.quote ?: "")
    }
}