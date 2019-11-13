package com.meta.weather.domain.usecase

import com.meta.weather.domain.base.UseCase
import com.meta.weather.domain.entity.LocationEntity
import com.meta.weather.domain.service.MetaWeatherService
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable

class GetLocationUseCase(
    private val weatherService: MetaWeatherService,
    composite: CompositeDisposable
) :
    UseCase<List<LocationEntity>, String>(composite) {

    override fun createFlowable(data: String): Flowable<List<LocationEntity>> =
        weatherService.getLocation(data)
}