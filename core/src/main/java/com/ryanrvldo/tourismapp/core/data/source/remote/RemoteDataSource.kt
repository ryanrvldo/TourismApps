package com.ryanrvldo.tourismapp.core.data.source.remote

import android.util.Log
import com.ryanrvldo.tourismapp.core.data.source.remote.network.ApiResponse
import com.ryanrvldo.tourismapp.core.data.source.remote.network.TourismApiService
import com.ryanrvldo.tourismapp.core.data.source.remote.response.TourismResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val tourismApiService: TourismApiService) {

    companion object {

        const val TAG = "RemoteDataSource"

    }

    fun getAllTourism(): Flow<ApiResponse<List<TourismResponse>>> = flow {
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

