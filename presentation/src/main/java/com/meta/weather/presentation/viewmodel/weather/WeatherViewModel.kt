package com.meta.weather.presentation.viewmodel.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meta.weather.domain.entity.LocationWeatherInfoEntity
import com.meta.weather.domain.usecase.GetLocationUseCase
import com.meta.weather.domain.usecase.GetWeatherInfoUseCase
import com.meta.weather.presentation.base.SingleLiveEvent
import com.meta.weather.presentation.mapper.LocationWeatherInfoModelMapper
import com.meta.weather.presentation.model.LocationWeatherInfoModel
import io.reactivex.subscribers.DisposableSubscriber

class WeatherViewModel(
    private val getLocationUseCase: GetLocationUseCase,
    private val getWeatherInfoUseCase: GetWeatherInfoUseCase,
    private val locationWeatherInfoModelMapper: LocationWeatherInfoModelMapper
) : ViewModel() {

    val locationWeatherInfoListLiveData = MutableLiveData<ArrayList<LocationWeatherInfoModel>>()
    val toastSingleLiveEvent = SingleLiveEvent<String>()

    private val locationWeatherInfoList = ArrayList<LocationWeatherInfoModel>()

    private var locationCount: Int = 0
    private var isSearch = false

    private val locationSubscriber
        get() = object : DisposableSubscriber<List<String>>() {
            override fun onNext(t: List<String>) {
                locationCount = t.size

                if (locationCount > 0) {
                    t.forEach {
                        getWeatherInfoUseCase.execute(it, weatherInfoSubscriber)
                    }
                } else {
                    locationCounting()
                }
            }

            override fun onError(t: Throwable) {
                toastSingleLiveEvent.value = "오류로 인해 지역 날씨 정보를 가져올 수 없습니다!"
            }

            override fun onComplete() {}
        }

    private val weatherInfoSubscriber: DisposableSubscriber<LocationWeatherInfoEntity>
        get() = object : DisposableSubscriber<LocationWeatherInfoEntity>() {
            override fun onNext(t: LocationWeatherInfoEntity) {
                val locationWeatherInfoModel = locationWeatherInfoModelMapper.mapFrom(t)

                locationWeatherInfoList.add(locationWeatherInfoModel)
            }

            override fun onError(t: Throwable) = locationCounting()

            override fun onComplete() = locationCounting()
        }

    fun getLocation() {
        if (!isSearch) {
            locationCount = 0
            isSearch = true
            locationWeatherInfoList.clear()
            getLocationUseCase.execute("se", locationSubscriber)
        } else {
            toastSingleLiveEvent.value = "지역 날씨 정보 가져오는 중..."
        }
    }

    private fun locationCounting() {
        locationCount--
        if (locationCount <= 0) {
            if (locationWeatherInfoList.size > 0) {
                locationWeatherInfoList.sortBy { it.locationName }
                locationWeatherInfoListLiveData.value = locationWeatherInfoList
                toastSingleLiveEvent.value = "성공!"
            } else {
                toastSingleLiveEvent.value = "지역 날씨 정보가 없습니다."
            }
            isSearch = false
        }
    }

    override fun onCleared() {
        super.onCleared()
        getLocationUseCase.clear()
        getWeatherInfoUseCase.clear()
    }
}