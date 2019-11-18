package com.meta.weather.data.repository

import com.meta.weather.data.datasource.MetaWeatherDataSource
import com.meta.weather.data.mapper.LocationWeatherInfoEntityMapper
import com.meta.weather.domain.entity.LocationWeatherInfoEntity
import com.meta.weather.domain.repository.MetaWeatherRepository
import io.reactivex.Flowable

class MetaWeatherRepositoryImpl(
    private val metaWeatherDataSource: MetaWeatherDataSource,
    private val locationWeatherInfoEntityMapper: LocationWeatherInfoEntityMapper
) : MetaWeatherRepository {

    override fun getLocation(keyword: String): Flowable<List<String>> =
        metaWeatherDataSource.getLocation(keyword)
            .map { locationDataList ->
                val locationList = ArrayList<String>()

                locationDataList.forEach {
                    locationList.add(it.woeid)
                }

                locationList
            }

    override fun getWeather(locationId: String): Flowable<LocationWeatherInfoEntity> =
        metaWeatherDataSource.getWeather(locationId)
            .map { locationWeatherInfo -> locationWeatherInfoEntityMapper.mapFrom(locationWeatherInfo) }
}