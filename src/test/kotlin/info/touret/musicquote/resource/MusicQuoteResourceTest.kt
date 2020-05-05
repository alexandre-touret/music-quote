package info.touret.musicquote.resource

import info.touret.musicquote.dto.MusicQuoteDTO
import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.h2.H2DatabaseTestResource
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import io.restassured.common.mapper.TypeRef
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test
import javax.ws.rs.core.HttpHeaders.CONTENT_TYPE
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@QuarkusTestResource(H2DatabaseTestResource::class)
@QuarkusTest()
open class MusicQuoteResourceTest {

    @Test
    fun should_get_200() {
        RestAssured.given()
                .`when`()["/music-quote/random"]
                .then()
                .statusCode(200)
    }

    @Test
    fun should_get_a_quote() {
        RestAssured.given()
                .`when`()["/music-quote/random"]
                .then()
                .statusCode(200)
                .body("author", CoreMatchers.notNullValue())

    }

    @Test
    fun should_get_a_quote_serialized() {
        RestAssured.given()
                .`when`()["/music-quote/random"]
                .then()
                .statusCode(200)
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .extract().body().`as`(getMusicQuoteTypeRef());
    }

    private fun getMusicQuoteTypeRef(): TypeRef<MusicQuoteDTO?>? {
        return object : TypeRef<MusicQuoteDTO?>() { // Kept empty on purpose
        }
    }
}