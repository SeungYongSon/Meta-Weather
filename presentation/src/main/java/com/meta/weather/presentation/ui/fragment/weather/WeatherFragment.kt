package com.meta.weather.presentation.ui.fragment.weather

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
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

    override val viewModel by lazy {
        ViewModelProviders.of(this, factory).get(WeatherViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.locationWeatherInfoListLiveData.observe(this, Observer {
            it.forEach{info ->
                Log.e("Meta Weather", "${info.locationName} first ${info.weatherInfo.first.temp} second ${info.weatherInfo.second.temp}")
            }
        })

        viewModel.toastSingleLiveEvent.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })

        binding.vm = viewModel
        viewModel.getLocation()
    }
}