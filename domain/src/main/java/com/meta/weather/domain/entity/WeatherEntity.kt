package com.meta.weather.domain.entity

data class WeatherEntity(
    val state: String,
    val icon: String,
    val temp: Double,
    val humidity: Int
)