package info.touret.musicquote.repository

import info.touret.musicquote.model.MusicQuote
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.persistence.EntityManager
import kotlin.random.Random

@ApplicationScoped
class MusicQuoteRepository {
    @Inject
    @field: Default
    lateinit var entityManager: EntityManager


    fun findARandomMusicQuote(): MusicQuote? {
        val query = entityManager.criteriaBuilder.createQuery(MusicQuote::class.java)
        val root = query?.from(MusicQuote::class.java)
        val quotes = entityManager.createQuery(query)?.resultList
        val quotesSize = quotes?.size ?: 0
        if (quotesSize > 0) {
            return quotes?.get(Random(quotesSize).nextInt())
        } else {
            return null
        }
    }
}