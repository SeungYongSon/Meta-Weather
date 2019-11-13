package com.meta.weather.data.dto

import com.google.gson.annotations.SerializedName
import com.meta.weather.data.entity.WeatherData

data class WeatherDTO(
    @SerializedName("consolidated_weather")
    val consolidated_weather: List<WeatherData>
)