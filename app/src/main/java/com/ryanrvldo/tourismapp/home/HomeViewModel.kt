package com.ryanrvldo.tourismapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ryanrvldo.tourismapp.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism().asLiveData()

}

