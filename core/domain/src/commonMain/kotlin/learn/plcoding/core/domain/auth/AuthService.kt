package learn.plcoding.core.domain.auth

import learn.plcoding.core.domain.util.DataError
import learn.plcoding.core.domain.util.EmptyResult

interface AuthService {
    suspend fun register(
        email: String,
        username: String,
        password: String
    ): EmptyResult<DataError.Remote>
}