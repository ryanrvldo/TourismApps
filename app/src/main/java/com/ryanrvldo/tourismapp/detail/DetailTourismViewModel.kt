package com.ryanrvldo.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.ryanrvldo.tourismapp.core.data.TourismRepository
import com.ryanrvldo.tourismapp.core.data.source.local.entity.TourismEntity

class DetailTourismViewModel(private val tourismRepository: TourismRepository) : ViewModel() {
    fun setFavoriteTourism(tourism: TourismEntity, newStatus:Boolean) = tourismRepository.setFavoriteTourism(tourism, newStatus)
}

