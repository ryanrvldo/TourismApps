package com.ryanrvldo.tourismapp.favorite

import androidx.lifecycle.ViewModel
import com.ryanrvldo.tourismapp.core.data.TourismRepository

class FavoriteViewModel(tourismRepository: TourismRepository) : ViewModel() {

    val favoriteTourism = tourismRepository.getFavoriteTourism()

}

