package com.ryanrvldo.tourismapp.core.domain.repository

import com.ryanrvldo.tourismapp.core.data.Resource
import com.ryanrvldo.tourismapp.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismRepository {

    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}