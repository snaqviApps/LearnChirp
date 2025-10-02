package learn.plcoding.mychirp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform