package com.meta.weather.data.datasource

import com.meta.weather.data.entity.LocationData
import com.meta.weather.data.entity.LocationWeatherInfoData
import io.reactivex.Flowable

interface MetaWeatherDataSource {
    fun getLocation(keyword: String): Flowable<List<LocationData>>
    fun getWeather(locationId: String): Flowable<LocationWeatherInfoData>
}