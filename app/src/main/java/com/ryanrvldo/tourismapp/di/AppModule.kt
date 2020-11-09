package com.ryanrvldo.tourismapp.di

import com.ryanrvldo.tourismapp.core.domain.usecase.TourismUseCase
import com.ryanrvldo.tourismapp.core.domain.usecase.impl.TourismUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(tourismUseCaseImpl: TourismUseCaseImpl): TourismUseCase

}