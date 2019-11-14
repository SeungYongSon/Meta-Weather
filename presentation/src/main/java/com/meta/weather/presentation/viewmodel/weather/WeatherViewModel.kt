package com.meta.weather.presentation.viewmodel.weather

import androidx.lifecycle.ViewModel
import com.meta.weather.domain.usecase.GetLocationUseCase
import com.meta.weather.domain.usecase.GetWeatherInfoUseCase

class WeatherViewModel(
    private val getLocationUseCase: GetLocationUseCase,
    private val getWeatherInfoUseCase: GetWeatherInfoUseCase
) : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        getLocationUseCase.clear()
        getWeatherInfoUseCase.clear()
    }
}