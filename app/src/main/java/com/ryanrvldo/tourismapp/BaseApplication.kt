package com.ryanrvldo.tourismapp

import android.app.Application
import com.ryanrvldo.tourismapp.core.di.CoreComponent
import com.ryanrvldo.tourismapp.core.di.DaggerCoreComponent
import com.ryanrvldo.tourismapp.di.AppComponent
import com.ryanrvldo.tourismapp.di.DaggerAppComponent

open class BaseApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }

}