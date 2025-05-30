package com.sandeshshetty.starhelper

import android.app.Application
import com.sandeshshetty.auth.data.di.authDataModule
import com.sandeshshetty.auth.presentation.di.authViewModelModule
import com.sandeshshetty.core.database.di.databaseModule
import com.sandeshshetty.home.presentation.di.homeViewModelModule
import com.sandeshshetty.starhelper.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * @author sandeshshetty
 * Created 5/6/25 at {TIME}
 */
class StarHelperApp: Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@StarHelperApp)
            modules(
                appModule,
                authDataModule,
                authViewModelModule,
                homeViewModelModule,
                databaseModule
            )
        }
    }
}