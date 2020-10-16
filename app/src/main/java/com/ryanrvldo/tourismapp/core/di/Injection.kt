package com.ryanrvldo.tourismapp.core.di

import android.content.Context

import com.ryanrvldo.tourismapp.core.data.source.local.LocalDataSource
import com.ryanrvldo.tourismapp.core.data.source.local.room.TourismDatabase

import com.ryanrvldo.tourismapp.core.data.TourismRepository
import com.ryanrvldo.tourismapp.core.data.source.remote.RemoteDataSource
import com.ryanrvldo.tourismapp.core.utils.AppExecutors
import com.ryanrvldo.tourismapp.core.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): TourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
