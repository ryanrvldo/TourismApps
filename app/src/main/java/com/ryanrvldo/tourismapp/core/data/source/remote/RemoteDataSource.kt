package com.ryanrvldo.tourismapp.core.data.source.remote

import android.annotation.SuppressLint
import android.util.Log
import com.ryanrvldo.tourismapp.core.data.source.remote.network.ApiResponse
import com.ryanrvldo.tourismapp.core.data.source.remote.network.TourismApiService
import com.ryanrvldo.tourismapp.core.data.source.remote.response.TourismResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

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

    @SuppressLint("CheckResult")
    fun getAllTourism(): Flowable<ApiResponse<List<TourismResponse>>> {
        val resultData = PublishSubject.create<ApiResponse<List<TourismResponse>>>()

        //get data from remote api
        tourismApiService.getList()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({ response ->
                val dataList = response.tourismResponseList
                resultData.onNext(if (dataList.isNotEmpty()) ApiResponse.Success(dataList) else ApiResponse.Empty)
            }, { error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e(TAG, error.toString())
            })

        return resultData.toFlowable((BackpressureStrategy.BUFFER))
    }
}

