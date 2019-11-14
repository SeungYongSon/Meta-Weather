package com.meta.weather.data.repository

import com.meta.weather.data.datasource.MetaWeatherDataSource
import com.meta.weather.data.mapper.LocationEntityMapper
import com.meta.weather.data.mapper.WeatherEntityMapper
import com.meta.weather.domain.entity.LocationEntity
import com.meta.weather.domain.entity.WeatherEntity
import com.meta.weather.domain.repository.MetaWeatherRepository
import io.reactivex.Flowable

class MetaWeatherRepositoryImpl(
    private val metaWeatherDataSource: MetaWeatherDataSource,
    private val locationMapper: LocationEntityMapper,
    private val weatherMapper: WeatherEntityMapper
) : MetaWeatherRepository {

    override fun getLocation(keyword: String): Flowable<List<LocationEntity>> =
        metaWeatherDataSource.getLocation(keyword)
            .map { locationDataList ->
                val locationList = ArrayList<LocationEntity>()

                locationDataList.forEach {
                    val locationEntity = locationMapper.mapFrom(it)
                    locationList.add(locationEntity)
                }

                locationList
            }

    override fun getWeather(locationId: String): Flowable<List<WeatherEntity>> =
        metaWeatherDataSource.getWeather(locationId)
            .map { weatherDTO ->
                val weatherDataList = weatherDTO.consolidated_weather
                val weatherEntityList = ArrayList<WeatherEntity>()

                weatherDataList.forEach {
                    val weatherEntity = weatherMapper.mapFrom(it)
                    weatherEntityList.add(weatherEntity)
                }

                weatherEntityList
            }
}