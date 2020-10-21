package com.ryanrvldo.tourismapp.core.domain.usecase.impl

import com.ryanrvldo.tourismapp.core.domain.model.Tourism
import com.ryanrvldo.tourismapp.core.domain.repository.TourismRepository
import com.ryanrvldo.tourismapp.core.domain.usecase.TourismUseCase
import javax.inject.Inject

class TourismUseCaseImpl @Inject constructor(
    private val tourismRepository: TourismRepository
) : TourismUseCase {

    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) =
        tourismRepository.setFavoriteTourism(tourism, state)

}