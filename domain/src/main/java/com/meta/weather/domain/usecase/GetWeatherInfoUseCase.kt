package com.meta.weather.domain.usecase

import com.meta.weather.domain.base.UseCase
import com.meta.weather.domain.entity.WeatherEntity
import com.meta.weather.domain.service.MetaWeatherService
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable

class GetWeatherInfoUseCase(
    private val weatherService: MetaWeatherService,
    composite: CompositeDisposable
) : UseCase<Pair<WeatherEntity, WeatherEntity>, String>(composite) {

    override fun createFlowable(data: String): Flowable<Pair<WeatherEntity, WeatherEntity>> =
        weatherService.getWeather(data)
}