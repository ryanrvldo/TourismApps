package com.ryanrvldo.tourismapp.core.utils

import com.ryanrvldo.tourismapp.core.data.source.local.entity.TourismEntity
import com.ryanrvldo.tourismapp.core.data.source.remote.response.TourismResponse
import com.ryanrvldo.tourismapp.core.domain.model.Tourism

object DataMapper {

    fun mapResponsesToEntities(input: List<TourismResponse>): List<TourismEntity> {
        val tourismList = ArrayList<TourismEntity>()
        input.map {
            val tourism = TourismEntity(
                tourismId = it.id,
                name = it.name,
                description = it.description,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<TourismEntity>): List<Tourism> =
        input.map { entity ->
            Tourism(
                tourismId = entity.tourismId,
                name = entity.name,
                description = entity.description,
                address = entity.address,
                latitude = entity.latitude,
                longitude = entity.longitude,
                like = entity.like,
                image = entity.image,
                isFavorite = entity.isFavorite
            )
        }

    fun mapDomainToEntity(input: Tourism) = TourismEntity(
        tourismId = input.tourismId,
        name = input.name,
        description = input.description,
        address = input.address,
        latitude = input.latitude,
        longitude = input.longitude,
        like = input.like,
        image = input.image,
        isFavorite = input.isFavorite
    )

}