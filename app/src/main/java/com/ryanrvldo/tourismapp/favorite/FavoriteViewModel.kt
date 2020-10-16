package com.ryanrvldo.tourismapp.favorite

import androidx.lifecycle.ViewModel
import com.ryanrvldo.tourismapp.core.data.TourismRepositoryImpl
import com.ryanrvldo.tourismapp.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism()

}

