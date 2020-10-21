package com.ryanrvldo.tourismapp.di

import com.ryanrvldo.tourismapp.core.domain.usecase.TourismUseCase
import com.ryanrvldo.tourismapp.core.domain.usecase.impl.TourismUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(tourismUseCaseImpl: TourismUseCaseImpl): TourismUseCase

}