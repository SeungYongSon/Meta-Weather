package com.meta.weather.presentation.ui.fragment.weather

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.meta.weather.presentation.R
import com.meta.weather.presentation.base.DataBindingFragment
import com.meta.weather.presentation.databinding.FragmentWeatherBinding
import com.meta.weather.presentation.viewmodel.weather.WeatherViewModel
import com.meta.weather.presentation.viewmodel.weather.WeatherViewModelFactory
import javax.inject.Inject

class WeatherFragment : DataBindingFragment<FragmentWeatherBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_weather

    @Inject
    lateinit var factory: WeatherViewModelFactory

    override val viewModel
            by lazy { ViewModelProviders.of(this, factory).get(WeatherViewModel::class.java) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel
    }
}