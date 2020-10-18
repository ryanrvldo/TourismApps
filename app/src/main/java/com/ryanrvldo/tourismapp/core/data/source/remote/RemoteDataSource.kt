package com.ryanrvldo.tourismapp.core.data.source.remote

import android.util.Log
import com.ryanrvldo.tourismapp.core.data.source.remote.network.ApiResponse
import com.ryanrvldo.tourismapp.core.data.source.remote.network.TourismApiService
import com.ryanrvldo.tourismapp.core.data.source.remote.response.TourismResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource private constructor(private val tourismApiService: TourismApiService) {

    companion object {

        const val TAG = "RemoteDataSource"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: TourismApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }

    fun getAllTourism(): Flow<ApiResponse<List<TourismResponse>>> {
        //get data from remote api
        return flow {
            try {
                val response = tourismApiService.getList()
                val dataList = response.tourismResponseList
                if (dataList.isNotEmpty()) {
                    emit(ApiResponse.Success(response.tourismResponseList))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e(TAG, e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}

