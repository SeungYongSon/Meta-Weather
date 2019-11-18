package com.meta.weather.data.remote

import com.meta.weather.data.entity.LocationData
import com.meta.weather.data.entity.LocationWeatherInfoData
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("location/search/")
    fun search(@Query("query") keyword: String): Flowable<List<LocationData>>

    @GET("location/{location_id}")
    fun locationWeather(@Path("location_id") locationId: String): Flowable<LocationWeatherInfoData>
}