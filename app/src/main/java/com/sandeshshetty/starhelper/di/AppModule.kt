package com.sandeshshetty.starhelper.di

import com.sandeshshetty.auth.data.EmailPatternValidtor
import com.sandeshshetty.auth.domain.PatternValidator
import com.sandeshshetty.auth.domain.UserDataValidator
import com.sandeshshetty.starhelper.MainViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * @author sandeshshetty
 * Created 5/6/25 at {TIME}
 */

val appModule = module {
    viewModelOf(::MainViewModel)
}