package com.meta.weather.domain.entity

data class LocationWeatherInfoEntity(
    val locationName: String,
    val weatherInfo: List<WeatherEntity>
)