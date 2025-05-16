package com.sandeshshetty.home.presentation.di

import com.sandeshshetty.home.presentation.dashboard.DashboardViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

/**
 * @author sandeshshetty
 * Created 5/15/25 at {TIME}
 */

val homeViewModelModule = module {
    viewModelOf(::DashboardViewModel)
}