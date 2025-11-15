package learn.plcoding.core.domain.logging

interface MyChirpLogger {
    fun info(message: String)
    fun debug(message: String)
    fun warn(message: String)
    fun error(message: String, throwable: Throwable? = null)
}