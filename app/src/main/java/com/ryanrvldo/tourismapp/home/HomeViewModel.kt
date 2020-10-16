package com.ryanrvldo.tourismapp.home

import androidx.lifecycle.ViewModel
import com.ryanrvldo.tourismapp.core.data.TourismRepositoryImpl
import com.ryanrvldo.tourismapp.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism()

}

