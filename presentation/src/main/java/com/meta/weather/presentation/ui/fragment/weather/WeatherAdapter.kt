package com.meta.weather.presentation.ui.fragment.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.meta.weather.presentation.BR
import com.meta.weather.presentation.databinding.ItemLocationWeatherInfoBinding
import com.meta.weather.presentation.model.LocationWeatherInfoModel
import com.meta.weather.presentation.viewmodel.weather.WeatherViewModel

class LocationWeatherInfoAdapter(private val viewModel: WeatherViewModel) :
    RecyclerView.Adapter<LocationWeatherInfoAdapter.LocationWeatherInfoViewHolder>() {

    private var locationWeatherInfoItems = ArrayList<LocationWeatherInfoModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationWeatherInfoViewHolder {
        val binding =
            ItemLocationWeatherInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        binding.vm = viewModel

        return LocationWeatherInfoViewHolder(binding)
    }

    override fun getItemCount(): Int = locationWeatherInfoItems.size

    override fun onBindViewHolder(holder: LocationWeatherInfoViewHolder, position: Int) =
        holder.bind(locationWeatherInfoItems[position])

    fun setItem(locationWeatherInfoItems: MutableLiveData<ArrayList<LocationWeatherInfoModel>>){
        this.locationWeatherInfoItems = locationWeatherInfoItems.value!!
        notifyDataSetChanged()
    }

    class LocationWeatherInfoViewHolder(private val binding: ItemLocationWeatherInfoBinding) :
        RecyclerView.ViewHolder(binding.root.rootView) {

        fun bind(weatherInfo: LocationWeatherInfoModel) {
            binding.setVariable(BR.locationName, weatherInfo.locationName)
            binding.setVariable(BR.todayWeather, weatherInfo.weatherInfo.first)
            binding.setVariable(BR.tomorrowWeather, weatherInfo.weatherInfo.second)
        }
    }
}