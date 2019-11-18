package com.meta.weather.data.mapper

import com.meta.weather.data.entity.LocationWeatherInfoData
import com.meta.weather.domain.base.Mapper
import com.meta.weather.domain.entity.LocationWeatherInfoEntity
import com.meta.weather.domain.entity.WeatherEntity

class LocationWeatherInfoEntityMapper(private val weatherEntityMapper: WeatherEntityMapper) : Mapper<LocationWeatherInfoData, LocationWeatherInfoEntity> {

    override fun mapFrom(from: LocationWeatherInfoData): LocationWeatherInfoEntity {
        val weatherDataList = from.consolidated_weather
        val weatherEntityList = ArrayList<WeatherEntity>()

        weatherDataList.forEach {
            val weatherEntity = weatherEntityMapper.mapFrom(it)
            weatherEntityList.add(weatherEntity)
        }

        return LocationWeatherInfoEntity(
            locationName = from.title,
            weatherInfo = weatherEntityList
        )
    }
}