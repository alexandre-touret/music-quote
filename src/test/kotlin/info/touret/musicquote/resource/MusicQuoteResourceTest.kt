package info.touret.musicquote.resource

import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.h2.H2DatabaseTestResource
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured
import org.junit.jupiter.api.Test

@QuarkusTestResource(H2DatabaseTestResource::class)
@QuarkusTest
open class MusicQuoteResourceTest {
    @Test
    fun testHelloEndpoint() {
        RestAssured.given()
                .`when`()["/music-quote/random"]
                .then()
                .statusCode(200)
    }
}