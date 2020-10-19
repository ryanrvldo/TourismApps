package com.ryanrvldo.tourismapp

import android.app.Application
import com.ryanrvldo.tourismapp.core.di.databaseModule
import com.ryanrvldo.tourismapp.core.di.networkModule
import com.ryanrvldo.tourismapp.core.di.repositoryModule
import com.ryanrvldo.tourismapp.di.useCaseModule
import com.ryanrvldo.tourismapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                databaseModule,
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }

}