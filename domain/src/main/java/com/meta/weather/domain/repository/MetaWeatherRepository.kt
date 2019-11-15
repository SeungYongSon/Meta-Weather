package com.meta.weather.domain.repository

import com.meta.weather.domain.entity.LocationWeatherInfoEntity
import io.reactivex.Flowable

interface MetaWeatherRepository {
    fun getLocation(keyword: String): Flowable<List<String>>
    fun getWeather(locationId: String): Flowable<LocationWeatherInfoEntity>
}