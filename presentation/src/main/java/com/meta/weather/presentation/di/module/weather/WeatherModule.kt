package com.meta.weather.presentation.di.module.weather

import com.meta.weather.data.datasource.MetaWeatherDataSource
import com.meta.weather.data.datasource.MetaWeatherDataSourceImpl
import com.meta.weather.data.mapper.LocationMapper
import com.meta.weather.data.mapper.WeatherMapper
import com.meta.weather.data.remote.Api
import com.meta.weather.data.repository.MetaWeatherRepositoryImpl
import com.meta.weather.domain.repository.MetaWeatherRepository
import com.meta.weather.domain.service.MetaWeatherService
import com.meta.weather.domain.service.MetaWeatherServiceImpl
import com.meta.weather.domain.usecase.GetLocationUseCase
import com.meta.weather.domain.usecase.GetWeatherInfoUseCase
import com.meta.weather.presentation.di.scope.FragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit

@Module
class WeatherModule {

    @Provides
    @FragmentScope
    fun provideComposite(): CompositeDisposable = CompositeDisposable()

    @Provides
    @FragmentScope
    fun provideAPI(retrofit: Retrofit): Api = retrofit.create(Api::class.java)

    @Provides
    @FragmentScope
    fun provideMetaWeatherDataSource(api: Api) = MetaWeatherDataSourceImpl(api)

    @Provides
    @FragmentScope
    fun provideMetaWeatherRepository(metaWeatherDataSource: MetaWeatherDataSource): MetaWeatherRepository =
        MetaWeatherRepositoryImpl(metaWeatherDataSource, LocationMapper(), WeatherMapper())

    @Provides
    @FragmentScope
    fun provideMetaWeatherService(metaWeatherRepository: MetaWeatherRepository): MetaWeatherService =
        MetaWeatherServiceImpl(metaWeatherRepository)

    @Provides
    @FragmentScope
    fun provideGetLocationUseCase(
        metaWeatherService: MetaWeatherService,
        composite: CompositeDisposable
    ): GetLocationUseCase = GetLocationUseCase(metaWeatherService, composite)

    @Provides
    @FragmentScope
    fun provideGetWeatherInfoUseCase(
        metaWeatherService: MetaWeatherService,
        composite: CompositeDisposable
    ): GetWeatherInfoUseCase = GetWeatherInfoUseCase(metaWeatherService, composite)
}