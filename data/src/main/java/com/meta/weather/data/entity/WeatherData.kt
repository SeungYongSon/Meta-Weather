package com.meta.weather.data.entity

data class WeatherData(
    val weather_state_name: String,
    val weather_state_abbr: String,
    val the_temp: Float,
    val humidity: Int
)