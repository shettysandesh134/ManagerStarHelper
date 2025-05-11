package com.sandeshshetty.auth.presentation.di

import com.sandeshshetty.auth.presentation.login.LoginViewModel
import com.sandeshshetty.auth.presentation.register.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * @author sandeshshetty
 * Created 5/6/25 at {TIME}
 */

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}