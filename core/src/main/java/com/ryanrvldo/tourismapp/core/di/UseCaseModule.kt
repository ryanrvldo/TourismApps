package com.ryanrvldo.tourismapp.core.di

import com.ryanrvldo.tourismapp.core.domain.usecase.TourismUseCase
import com.ryanrvldo.tourismapp.core.domain.usecase.impl.TourismUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun provideTourismUseCase(tourismUseCaseImpl: TourismUseCaseImpl): TourismUseCase

}
