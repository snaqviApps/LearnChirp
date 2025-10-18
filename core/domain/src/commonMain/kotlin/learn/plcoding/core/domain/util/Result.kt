package learn.plcoding.core.domain.util

sealed interface Result<out D, out E: Error> {
    data class Success<out D>(val data: D) : Result<D, Nothing>
    data class Failure<out E: Error>(val error: E) : Result<Nothing, E>
}

inline fun <T, E: Error, R> Result<T, E>.map(map: (T) -> R): Result<R, E> {
    return when (this) {
        is Result.Failure -> Result.Failure(error)
        is Result.Success -> Result.Success(map(data))
    }
}

inline fun <T, E: Error> Result<T, E>.onSuccess(action: (T) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Failure -> this
        is Result.Success -> {
            action(data)
            this
        }
    }
}

inline fun <T, E: Error> Result<T, E>.onFailure(action: (E) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Success -> this
        is Result.Failure -> {
            action(error)
            this
        }
    }
}

fun <T, E: Error, R> Result<T, E>.asEmptyResult() : EmptyResult<E> {            // inline not needed as no lambda is here
    return map {  }
}

fun loadChat() : Result<List<String>, DataError.Remote> {
    return Result.Success(listOf("Hello World", "Chat People"))          // later replace with repository provided data
}

typealias EmptyResult<E> = Result<Unit, E>                                      // holds results with No value
