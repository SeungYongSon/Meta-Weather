package com.meta.weather.data.entity

import com.google.gson.annotations.SerializedName

data class LocationData(
    @SerializedName("woeid")
    val woeid: String
)