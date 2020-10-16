package com.ryanrvldo.tourismapp.home

import androidx.lifecycle.ViewModel
import com.ryanrvldo.tourismapp.core.data.TourismRepository

class HomeViewModel(tourismRepository: TourismRepository) : ViewModel() {

    val tourism = tourismRepository.getAllTourism()

}

