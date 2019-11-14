package com.meta.weather.presentation.viewmodel.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.meta.weather.domain.usecase.GetLocationUseCase
import com.meta.weather.domain.usecase.GetWeatherInfoUseCase

class WeatherViewModelFactory(
    private val getLocationUseCase: GetLocationUseCase,
    private val getWeatherInfoUseCase: GetWeatherInfoUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(
            GetLocationUseCase::class.java,
            GetWeatherInfoUseCase::class.java
        ).newInstance()
}