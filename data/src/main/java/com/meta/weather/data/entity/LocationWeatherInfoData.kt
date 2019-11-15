package com.meta.weather.data.entity

import com.google.gson.annotations.SerializedName

data class LocationWeatherInfoData(
    @SerializedName("consolidated_weather")
    val consolidated_weather: List<WeatherData>,
    @SerializedName("title")
    val title: String
)