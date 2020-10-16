package com.ryanrvldo.tourismapp.core.di

import android.content.Context
import com.ryanrvldo.tourismapp.core.data.TourismRepositoryImpl
import com.ryanrvldo.tourismapp.core.data.source.local.LocalDataSource
import com.ryanrvldo.tourismapp.core.data.source.local.room.TourismDatabase
import com.ryanrvldo.tourismapp.core.data.source.remote.RemoteDataSource
import com.ryanrvldo.tourismapp.core.domain.repository.TourismRepository
import com.ryanrvldo.tourismapp.core.domain.usecase.TourismUseCase
import com.ryanrvldo.tourismapp.core.domain.usecase.impl.TourismUseCaseImpl
import com.ryanrvldo.tourismapp.core.utils.AppExecutors
import com.ryanrvldo.tourismapp.core.utils.JsonHelper

object Injection {

    private fun provideRepository(context: Context): TourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepositoryImpl.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): TourismUseCase {
        val repository = provideRepository(context)
        return TourismUseCaseImpl(repository)
    }

}