package com.ryanrvldo.tourismapp.core.data.source.remote.network

import com.ryanrvldo.tourismapp.core.data.source.remote.response.ListTourismResponse
import retrofit2.Call
import retrofit2.http.GET

interface TourismApiService {

    @GET("list")
    suspend fun getList(): ListTourismResponse

}