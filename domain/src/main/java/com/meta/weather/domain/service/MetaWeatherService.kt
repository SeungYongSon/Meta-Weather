package com.meta.weather.domain.service

import com.meta.weather.domain.entity.LocationWeatherInfoEntity
import io.reactivex.Flowable

interface MetaWeatherService {
    fun getLocation(keyword: String): Flowable<List<String>>
    fun getWeather(locationId: String): Flowable<LocationWeatherInfoEntity>
}