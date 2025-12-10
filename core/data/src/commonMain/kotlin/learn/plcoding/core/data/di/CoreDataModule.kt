package learn.plcoding.core.data.di

import learn.plcoding.core.data.auth.KtorAuthService
import learn.plcoding.core.data.logging.KermitLogger
import learn.plcoding.core.data.network.HttpClientFactory
import learn.plcoding.core.domain.auth.AuthService
import learn.plcoding.core.domain.logging.MyChirpLogger
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformCoreDataModule: Module

val coreDataModule = module {
    includes(platformCoreDataModule)
    single<MyChirpLogger> {
        KermitLogger
    }
    includes(platformCoreDataModule)
    single {
        HttpClientFactory(get())
            .create(get())
    }

    /**
     * if we need extra parameter in the constructor of AuthService here,
     * however it is not needed here so we take approach: below using 'singleOf()'
     */
//    single {
//        KtorAuthService(get(), get())
//    }
    singleOf(::KtorAuthService) bind AuthService::class
}