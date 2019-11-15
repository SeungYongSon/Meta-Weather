package com.meta.weather.data.mapper

import com.meta.weather.data.entity.WeatherData
import com.meta.weather.domain.base.Mapper
import com.meta.weather.domain.entity.WeatherEntity

class WeatherEntityMapper: Mapper<WeatherData, WeatherEntity> {
    override fun mapFrom(from: WeatherData): WeatherEntity =
        WeatherEntity(
            state = from.weather_state_name,
            icon = from.weather_state_abbr,
            humidity = from.humidity,
            temp = from.the_temp
        )
}