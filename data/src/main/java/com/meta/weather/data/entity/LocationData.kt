package com.meta.weather.data.entity

import com.google.gson.annotations.SerializedName

data class LocationData(
    @SerializedName("title")
    val title: String,
    @SerializedName("location_type")
    val location_type: String,
    @SerializedName("woeid")
    val woeid: String,
    @SerializedName("latt_long")
    val latt_long: String
)