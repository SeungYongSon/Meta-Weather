package com.meta.weather.presentation.ui.weather

import com.meta.weather.presentation.R
import com.meta.weather.presentation.base.BaseViewModel
import com.meta.weather.presentation.base.DataBindingFragment
import com.meta.weather.presentation.databinding.FragmentWeatherBinding

class WeatherFragment : DataBindingFragment<FragmentWeatherBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_weather

    override val viewModel: BaseViewModel
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}