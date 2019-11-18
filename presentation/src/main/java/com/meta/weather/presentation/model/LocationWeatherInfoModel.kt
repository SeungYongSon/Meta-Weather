package com.meta.weather.presentation.model

data class LocationWeatherInfoModel(
    val locationName: String,
    val weatherInfo: Pair<WeatherModel, WeatherModel>
)