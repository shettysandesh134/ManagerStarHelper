package com.sandeshshetty.auth.data.di

import com.sandeshshetty.auth.data.AuthRepositoryImpl
import com.sandeshshetty.auth.data.EmailPatternValidtor
import com.sandeshshetty.auth.domain.AuthRepository
import com.sandeshshetty.auth.domain.PatternValidator
import com.sandeshshetty.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * @author sandeshshetty
 * Created 5/6/25 at {TIME}
 */

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidtor()
    }

    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}