package com.sandeshshetty.core.database.di

import androidx.room.Room
import com.sandeshshetty.core.database.EmployeeDatabase
import com.sandeshshetty.core.database.RoomLocalDataSource
import com.sandeshshetty.core.domain.employee.LocalDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

/**
 * @author sandeshshetty
 * Created 5/29/25 at {TIME}
 */

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            EmployeeDatabase::class.java,
            "employee.db"
        ).build()
    }
    single { get<EmployeeDatabase>().employeeDao }

    singleOf(::RoomLocalDataSource).bind<LocalDataSource>()
}