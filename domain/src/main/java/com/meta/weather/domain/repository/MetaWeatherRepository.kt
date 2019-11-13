package com.meta.weather.domain.repository

import com.meta.weather.domain.entity.LocationEntity
import com.meta.weather.domain.entity.WeatherEntity
import io.reactivex.Flowable

interface MetaWeatherRepository {
    fun getLocation(keyword: String): Flowable<List<LocationEntity>>
    fun getWeather(cityId: String): Flowable<List<WeatherEntity>>
}