package info.touret.musicquote.repository

import info.touret.musicquote.model.MusicQuote
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.persistence.EntityManager
import kotlin.random.Random

@ApplicationScoped
class MusicQuoteRepository {
    @Inject
    @field: ApplicationScoped
    lateinit var entityManager: EntityManager

    fun findARandomMusicQuote(): MusicQuote? {
        val query = entityManager.criteriaBuilder.createQuery(MusicQuote::class.java)
        val root = query?.from(MusicQuote::class.java)
        val quotes = entityManager.createQuery(query).resultList
        val size = quotes?.size ?: 0
        return if (size > 0) quotes?.get(Random.nextInt(size - 1)) else null
    }
}