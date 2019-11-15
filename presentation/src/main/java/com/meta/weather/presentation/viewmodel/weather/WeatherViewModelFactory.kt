package com.meta.weather.presentation.viewmodel.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.meta.weather.domain.usecase.GetLocationUseCase
import com.meta.weather.domain.usecase.GetWeatherInfoUseCase
import com.meta.weather.presentation.mapper.LocationWeatherInfoModelMapper

class WeatherViewModelFactory(
    private val getLocationUseCase: GetLocationUseCase,
    private val getWeatherInfoUseCase: GetWeatherInfoUseCase,
    private val locationWeatherInfoModelMapper: LocationWeatherInfoModelMapper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(
            GetLocationUseCase::class.java,
            GetWeatherInfoUseCase::class.java,
            LocationWeatherInfoModelMapper::class.java
        ).newInstance(getLocationUseCase, getWeatherInfoUseCase, locationWeatherInfoModelMapper)
}