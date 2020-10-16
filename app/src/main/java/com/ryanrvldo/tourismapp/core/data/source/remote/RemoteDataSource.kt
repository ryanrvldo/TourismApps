package com.ryanrvldo.tourismapp.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ryanrvldo.tourismapp.core.data.source.remote.network.ApiResponse
import com.ryanrvldo.tourismapp.core.data.source.remote.network.TourismApiService
import com.ryanrvldo.tourismapp.core.data.source.remote.response.ListTourismResponse
import com.ryanrvldo.tourismapp.core.data.source.remote.response.TourismResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    fun getAllTourism(): LiveData<ApiResponse<List<TourismResponse>>> {
        val resultData = MutableLiveData<ApiResponse<List<TourismResponse>>>()

        //get data from remote api
        val client = tourismApiService.getList()

        client.enqueue(object : Callback<ListTourismResponse> {
            override fun onResponse(
                call: Call<ListTourismResponse>,
                response: Response<ListTourismResponse>
            ) {
                val dataList = response.body()?.tourismResponseList
                resultData.value =
                    if (dataList != null) ApiResponse.Success(dataList) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<ListTourismResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e(TAG, t.message.toString())
            }
        })

        return resultData
    }
}

