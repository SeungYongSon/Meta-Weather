package com.meta.weather.domain.service

import com.meta.weather.domain.entity.LocationEntity
import com.meta.weather.domain.entity.WeatherEntity
import com.meta.weather.domain.repository.MetaWeatherRepository
import io.reactivex.Flowable

class MetaWeatherServiceImpl(private val weatherRepository: MetaWeatherRepository) : MetaWeatherService {

    override fun getLocation(keyword: String): Flowable<List<LocationEntity>> =
        weatherRepository.getLocation(keyword)

    override fun getWeather(cityId: String): Flowable<Pair<WeatherEntity, WeatherEntity>> =
        weatherRepository.getWeather(cityId)
            .map { Pair(it[0], it[1]) }
}