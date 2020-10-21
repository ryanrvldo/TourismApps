package com.ryanrvldo.tourismapp.core.di

import android.content.Context
import androidx.room.Room
import com.ryanrvldo.tourismapp.core.data.source.local.room.TourismDao
import com.ryanrvldo.tourismapp.core.data.source.local.room.TourismDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TourismDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            TourismDatabase::class.java,
            "Tourism.db"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideTourismDao(database: TourismDatabase): TourismDao = database.tourismDao()

}