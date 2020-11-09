package com.ryanrvldo.tourismapp.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ryanrvldo.tourismapp.core.domain.usecase.TourismUseCase
import com.ryanrvldo.tourismapp.maps.di.MapsScope
import javax.inject.Inject

@MapsScope
class MapsViewModel @Inject constructor(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism().asLiveData()

}
