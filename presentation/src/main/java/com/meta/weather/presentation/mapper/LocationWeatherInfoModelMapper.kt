package com.meta.weather.presentation.mapper

import com.meta.weather.domain.base.Mapper
import com.meta.weather.domain.entity.LocationWeatherInfoEntity
import com.meta.weather.presentation.model.LocationWeatherInfoModel

class LocationWeatherInfoModelMapper(private val weatherModelMapper: WeatherModelMapper) : Mapper<LocationWeatherInfoEntity, LocationWeatherInfoModel> {

    override fun mapFrom(from: LocationWeatherInfoEntity): LocationWeatherInfoModel {
        val todayWeather = weatherModelMapper.mapFrom(from.weatherInfo[0])
        val tomorrowWeather = weatherModelMapper.mapFrom(from.weatherInfo[1])

        return LocationWeatherInfoModel(from.locationName, Pair(todayWeather, tomorrowWeather))
    }
}