package com.ryanrvldo.tourismapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.ryanrvldo.tourismapp.core.data.Resource
import com.ryanrvldo.tourismapp.core.domain.model.Tourism

interface TourismUseCase {


    fun getAllTourism(): LiveData<Resource<List<Tourism>>>

    fun getFavoriteTourism(): LiveData<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}