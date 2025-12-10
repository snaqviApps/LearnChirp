package learn.plcoding.mychirp.di

import learn.plcoding.auth.presentation.di.authPresentationModule
import learn.plcoding.core.data.di.coreDataModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

/**
 * helper function that initializes application / process for respective platform, depends where it is being called like android, iOS, desktop
 */
fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            coreDataModule,
            authPresentationModule
        )
    }
}