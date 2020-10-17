package com.ryanrvldo.tourismapp.core.domain.repository

import com.ryanrvldo.tourismapp.core.data.Resource
import com.ryanrvldo.tourismapp.core.domain.model.Tourism
import io.reactivex.Flowable

interface TourismRepository {

    fun getAllTourism(): Flowable<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flowable<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}