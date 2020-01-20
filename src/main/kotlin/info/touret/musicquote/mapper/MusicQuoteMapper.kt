package info.touret.musicquote.mapper

import info.touret.musicquote.dto.MusicQuoteDTO
import info.touret.musicquote.model.MusicQuote
import org.mapstruct.Mapper


@Mapper
interface MusicQuoteMapper {
    fun toMusicQuoteDTO(musicQuote: MusicQuote): MusicQuoteDTO
}