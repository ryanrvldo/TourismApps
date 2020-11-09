package com.ryanrvldo.tourismapp.core.di

import android.content.Context
import com.ryanrvldo.tourismapp.core.domain.repository.TourismRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class])
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository(): TourismRepository

}