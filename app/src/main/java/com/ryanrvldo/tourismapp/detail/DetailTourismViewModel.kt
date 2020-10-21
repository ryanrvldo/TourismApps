package com.ryanrvldo.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.ryanrvldo.tourismapp.core.domain.model.Tourism
import com.ryanrvldo.tourismapp.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class DetailTourismViewModel @Inject constructor(
    private val tourismUseCase: TourismUseCase
) : ViewModel() {

    fun setFavoriteTourism(tourism: Tourism, newStatus: Boolean) =
        tourismUseCase.setFavoriteTourism(tourism, newStatus)

}

