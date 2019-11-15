package com.meta.weather.presentation.model

data class WeatherModel(
    val state: String,
    val icon: String,
    val temp: String,
    val humidity: String
)