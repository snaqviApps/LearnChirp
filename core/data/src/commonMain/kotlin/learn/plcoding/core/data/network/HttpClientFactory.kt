package learn.plcoding.core.data.network

import com.plcoding.core.data.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import learn.plcoding.core.domain.logging.MyChirpLogger

class HttpClientFactory(
    private val myChirpLogger: MyChirpLogger
) {
    fun create(engine: HttpClientEngine): HttpClient {
        return HttpClient(engine) {
            install(ContentNegotiation) {
               json(
                   Json {
                       ignoreUnknownKeys = true
                   }
               )
            }
            install(HttpTimeout) {
                socketTimeoutMillis = 20_000L
                requestTimeoutMillis = 20_000L
            }

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        myChirpLogger.debug(message)
                    }
                }
                level = LogLevel.ALL
            }

            install(WebSockets){
                pingIntervalMillis = 20_000L
            }

            defaultRequest {
                header("Content-Type", BuildKonfig.API_KEY)
                contentType(ContentType.Application.Json)

            }
        }
    }
}