package com.ryanrvldo.tourismapp.core.data

import com.ryanrvldo.tourismapp.core.data.source.local.LocalDataSource
import com.ryanrvldo.tourismapp.core.data.source.remote.RemoteDataSource
import com.ryanrvldo.tourismapp.core.data.source.remote.network.ApiResponse
import com.ryanrvldo.tourismapp.core.data.source.remote.response.TourismResponse
import com.ryanrvldo.tourismapp.core.domain.model.Tourism
import com.ryanrvldo.tourismapp.core.domain.repository.TourismRepository
import com.ryanrvldo.tourismapp.core.utils.AppExecutors
import com.ryanrvldo.tourismapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TourismRepositoryImpl private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : TourismRepository {

    companion object {
        @Volatile
        private var instance: TourismRepositoryImpl? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): TourismRepositoryImpl =
            instance ?: synchronized(this) {
                instance ?: TourismRepositoryImpl(remoteData, localData, appExecutors)
            }
    }

    override fun getAllTourism(): Flow<Resource<List<Tourism>>> =
        object : NetworkBoundResource<List<Tourism>, List<TourismResponse>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Tourism>> {
                return localDataSource.getAllTourism().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Tourism>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TourismResponse>>> =
                remoteDataSource.getAllTourism()

            override suspend fun saveCallResult(data: List<TourismResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()

    override fun getFavoriteTourism(): Flow<List<Tourism>> {
        return localDataSource.getFavoriteTourism().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }

}

