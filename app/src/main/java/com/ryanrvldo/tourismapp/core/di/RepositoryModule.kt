package com.ryanrvldo.tourismapp.core.di

import com.ryanrvldo.tourismapp.core.data.TourismRepositoryImpl
import com.ryanrvldo.tourismapp.core.domain.repository.TourismRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepositoryImpl: TourismRepositoryImpl): TourismRepository

}