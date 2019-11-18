package com.meta.weather.presentation.di.module.weather

import com.meta.weather.data.datasource.MetaWeatherDataSource
import com.meta.weather.data.datasource.MetaWeatherDataSourceImpl
import com.meta.weather.data.mapper.LocationWeatherInfoEntityMapper
import com.meta.weather.data.mapper.WeatherEntityMapper
import com.meta.weather.data.remote.Api
import com.meta.weather.data.repository.MetaWeatherRepositoryImpl
import com.meta.weather.domain.repository.MetaWeatherRepository
import com.meta.weather.domain.service.MetaWeatherService
import com.meta.weather.domain.service.MetaWeatherServiceImpl
import com.meta.weather.domain.usecase.GetLocationUseCase
import com.meta.weather.domain.usecase.GetWeatherInfoUseCase
import com.meta.weather.presentation.di.scope.FragmentScope
import com.meta.weather.presentation.mapper.LocationWeatherInfoModelMapper
import com.meta.weather.presentation.mapper.WeatherModelMapper
import com.meta.weather.presentation.viewmodel.weather.WeatherViewModelFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

@Module
class WeatherStaticModule {

    @FragmentScope
    @Provides
    fun provideViewModelFactory(
        getLocationUseCase: GetLocationUseCase,
        getWeatherInfoUseCase: GetWeatherInfoUseCase,
        locationWeatherInfoModelMapper: LocationWeatherInfoModelMapper
    ): WeatherViewModelFactory = WeatherViewModelFactory(
        getLocationUseCase,
        getWeatherInfoUseCase,
        locationWeatherInfoModelMapper
    )

    @FragmentScope
    @Provides
    fun provideGetLocationUseCase(
        metaWeatherService: MetaWeatherService,
        composite: CompositeDisposable
    ): GetLocationUseCase = GetLocationUseCase(metaWeatherService, composite)

    @FragmentScope
    @Provides
    fun provideGetWeatherInfoUseCase(
        metaWeatherService: MetaWeatherService,
        composite: CompositeDisposable
    ): GetWeatherInfoUseCase = GetWeatherInfoUseCase(metaWeatherService, composite)

    @FragmentScope
    @Provides
    fun provideMetaWeatherService(metaWeatherRepository: MetaWeatherRepository): MetaWeatherService =
        MetaWeatherServiceImpl(metaWeatherRepository)

    @FragmentScope
    @Provides
    fun provideMetaWeatherRepository(
        metaWeatherDataSource: MetaWeatherDataSource,
        locationWeatherInfoEntityMapper: LocationWeatherInfoEntityMapper
    ): MetaWeatherRepository =
        MetaWeatherRepositoryImpl(
            metaWeatherDataSource,
            locationWeatherInfoEntityMapper
        )

    @FragmentScope
    @Provides
    fun provideMetaWeatherDataSource(api: Api): MetaWeatherDataSource =
        MetaWeatherDataSourceImpl(api)

    @FragmentScope
    @Provides
    fun provideAPI(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

    @FragmentScope
    @Provides
    fun provideWeatherEntityMapper(): WeatherEntityMapper = WeatherEntityMapper()

    @FragmentScope
    @Provides
    fun provideLocationWeatherInfoEntityMapper(weatherEntityMapper: WeatherEntityMapper): LocationWeatherInfoEntityMapper =
        LocationWeatherInfoEntityMapper(weatherEntityMapper)

    @FragmentScope
    @Provides
    fun provideWeatherModelMapper(): WeatherModelMapper = WeatherModelMapper()

    @FragmentScope
    @Provides
    fun provideLocationWeatherInfoModelMapper(weatherModelMapper: WeatherModelMapper): LocationWeatherInfoModelMapper =
        LocationWeatherInfoModelMapper(weatherModelMapper)
}