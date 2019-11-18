package com.meta.weather.presentation.mapper

import com.meta.weather.domain.base.Mapper
import com.meta.weather.domain.entity.WeatherEntity
import com.meta.weather.presentation.model.WeatherModel
import kotlin.math.round

class WeatherModelMapper : Mapper<WeatherEntity, WeatherModel> {
    override fun mapFrom(from: WeatherEntity): WeatherModel =
        WeatherModel(
            state = from.state,
            icon = "https://www.metaweather.com/static/img/weather/png/${from.icon}.png",
            temp = "${round(from.temp).toInt()}℃",
            humidity = "${from.humidity}%"
        )
}