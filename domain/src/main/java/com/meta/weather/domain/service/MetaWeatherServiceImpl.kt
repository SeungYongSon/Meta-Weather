package com.meta.weather.domain.service

import com.meta.weather.domain.entity.LocationWeatherInfoEntity
import com.meta.weather.domain.repository.MetaWeatherRepository
import io.reactivex.Flowable

class MetaWeatherServiceImpl(private val weatherRepository: MetaWeatherRepository) :
    MetaWeatherService {

    override fun getLocation(keyword: String): Flowable<List<String>> =
        weatherRepository.getLocation(keyword)

    override fun getWeather(locationId: String): Flowable<LocationWeatherInfoEntity> =
        weatherRepository.getWeather(locationId)
}