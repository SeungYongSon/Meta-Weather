package com.meta.weather.data.datasource

import com.meta.weather.data.dto.WeatherDTO
import com.meta.weather.data.entity.LocationData
import com.meta.weather.data.remote.Api
import io.reactivex.Flowable

class MetaWeatherDataSourceImpl(private val api: Api) : MetaWeatherDataSource {

    override fun getLocation(keyword: String): Flowable<List<LocationData>> =
        api.search(keyword)

    override fun getWeather(locationId: String): Flowable<WeatherDTO> =
        api.locationWeather(locationId)
}