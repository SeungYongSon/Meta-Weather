package com.meta.weather.data.mapper

import com.meta.weather.data.entity.LocationData
import com.meta.weather.domain.base.Mapper
import com.meta.weather.domain.entity.LocationEntity

class LocationEntityMapper : Mapper<LocationData, LocationEntity> {
    override fun mapFrom(from: LocationData): LocationEntity =
        LocationEntity(from.woeid, from.title)
}