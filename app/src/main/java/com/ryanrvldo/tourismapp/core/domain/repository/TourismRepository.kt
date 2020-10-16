package com.ryanrvldo.tourismapp.core.domain.repository

import androidx.lifecycle.LiveData
import com.ryanrvldo.tourismapp.core.data.Resource
import com.ryanrvldo.tourismapp.core.domain.model.Tourism

interface TourismRepository {

    fun getAllTourism(): LiveData<Resource<List<Tourism>>>

    fun getFavoriteTourism(): LiveData<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}