package info.touret.musicquote.repository

import info.touret.musicquote.model.MusicQuote
import org.hibernate.type.EntityType
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.persistence.EntityManager
import javax.persistence.OrderBy
import javax.persistence.criteria.Order
import javax.persistence.criteria.Root
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

    fun findAllQuotes(): List<MusicQuote> {
        val criteriaBuilder = entityManager.criteriaBuilder
        val query = criteriaBuilder.createQuery(MusicQuote::class.java)
        val root: Root<MusicQuote> = query.from(MusicQuote::class.java)
        query.orderBy(criteriaBuilder.asc(root.get<MusicQuote>("author")))
        return listOf<MusicQuote>().plus(entityManager.createQuery(query).resultList);
    }
}