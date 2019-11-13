package com.meta.weather.domain.service

import com.meta.weather.domain.entity.LocationEntity
import com.meta.weather.domain.entity.WeatherEntity
import io.reactivex.Flowable

interface MetaWeatherService {
    fun getLocation(keyword: String): Flowable<List<LocationEntity>>
    fun getWeather(cityId: String): Flowable<Pair<WeatherEntity, WeatherEntity>>
}