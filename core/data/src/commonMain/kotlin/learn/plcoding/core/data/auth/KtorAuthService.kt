package learn.plcoding.core.data.auth

import io.ktor.client.HttpClient
import learn.plcoding.core.data.dto.requests.RegisterRequest
import learn.plcoding.core.data.network.post
import learn.plcoding.core.domain.auth.AuthService
import learn.plcoding.core.domain.util.DataError
import learn.plcoding.core.domain.util.EmptyResult

class KtorAuthService(
    private val httpClient: HttpClient
) : AuthService {
    override suspend fun register(
        email: String,
        username: String,
        password: String
    ): EmptyResult<DataError.Remote> {
        return httpClient.post(
            route = "/auth/register",
            body = RegisterRequest(
                email = email,
                username = username,
                password = password
            )
        )
    }

}