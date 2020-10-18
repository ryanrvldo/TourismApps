package com.ryanrvldo.tourismapp.core.domain.usecase

import com.ryanrvldo.tourismapp.core.data.Resource
import com.ryanrvldo.tourismapp.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface TourismUseCase {


    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}