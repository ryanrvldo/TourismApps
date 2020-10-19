package com.ryanrvldo.tourismapp.di

import com.ryanrvldo.tourismapp.core.domain.usecase.TourismUseCase
import com.ryanrvldo.tourismapp.core.domain.usecase.impl.TourismUseCaseImpl
import com.ryanrvldo.tourismapp.detail.DetailTourismViewModel
import com.ryanrvldo.tourismapp.favorite.FavoriteViewModel
import com.ryanrvldo.tourismapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TourismUseCase> { TourismUseCaseImpl(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}