package info.touret.musicquote.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class MusicQuote(@Id @GeneratedValue var id: Int? = null, var author: String? = null, var quote: String? = null)

