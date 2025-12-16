package learn.plcoding.auth.presentation.di

import learn.plcoding.auth.presentation.register.RegisterViewModel
import learn.plcoding.auth.presentation.registerSuccess.RegisterSuccessViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authPresentationModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::RegisterSuccessViewModel)
}