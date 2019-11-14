package com.meta.weather.data.mapper

import com.meta.weather.data.entity.WeatherData
import com.meta.weather.domain.base.Mapper
import com.meta.weather.domain.entity.WeatherEntity

class WeatherEntityMapper : Mapper<WeatherData, WeatherEntity> {
    override fun mapFrom(from: WeatherData): WeatherEntity =
        WeatherEntity(
            from.weather_state_name,
            from.weather_state_abbr,
            from.the_temp,
            from.humidity
        )
}