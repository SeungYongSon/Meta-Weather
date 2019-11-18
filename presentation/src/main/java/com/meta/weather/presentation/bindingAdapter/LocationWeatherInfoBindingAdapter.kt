package com.meta.weather.presentation.bindingAdapter

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.meta.weather.presentation.model.LocationWeatherInfoModel
import com.meta.weather.presentation.ui.fragment.weather.LocationWeatherInfoAdapter
import com.meta.weather.presentation.viewmodel.weather.WeatherViewModel

@BindingAdapter("refreshLocation")
fun SwipeRefreshLayout.refreshLocation(viewModel: WeatherViewModel) {
    setOnRefreshListener {
        if (viewModel.locationWeatherInfoItemsLiveData.value!!.size > 0) {
            viewModel.getLocation()
        } else {
            isRefreshing = false
        }
    }
}

@BindingAdapter("setRefreshing")
fun SwipeRefreshLayout.setRefreshing(locationWeatherInfoItems: MutableLiveData<ArrayList<LocationWeatherInfoModel>>) {
    if (locationWeatherInfoItems.value!!.size > 0 && isRefreshing) isRefreshing = false
}

@BindingAdapter("goneToProgressBar")
fun View.goneToProgressBar(locationWeatherInfoItems: MutableLiveData<ArrayList<LocationWeatherInfoModel>>) {
    if (locationWeatherInfoItems.value!!.size > 0 && visibility == VISIBLE) visibility = GONE
}

@BindingAdapter("visibleOrGone")
fun View.setVisibleOrGone(locationWeatherInfoItems: MutableLiveData<ArrayList<LocationWeatherInfoModel>>) {
    visibility = if (locationWeatherInfoItems.value!!.size > 0) VISIBLE else GONE
}

@BindingAdapter("locationWeatherInfoItems")
fun RecyclerView.locationWeatherInfoItems(locationWeatherInfoItems: MutableLiveData<ArrayList<LocationWeatherInfoModel>>) {
    (adapter as LocationWeatherInfoAdapter).setItem(locationWeatherInfoItems)
}

@BindingAdapter("imageUrl")
fun ImageView.imageUrl(imageUrl: String) {
    Glide.with(context)
        .load(imageUrl)
        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        .into(this)
}