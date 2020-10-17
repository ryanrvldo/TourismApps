package com.ryanrvldo.tourismapp.core.data.source.remote.network

import com.ryanrvldo.tourismapp.core.data.source.remote.response.ListTourismResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface TourismApiService {

    @GET("list")
    fun getList(): Flowable<ListTourismResponse>

}