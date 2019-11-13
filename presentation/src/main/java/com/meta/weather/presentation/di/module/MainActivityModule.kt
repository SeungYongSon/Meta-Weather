package com.meta.weather.presentation.di.module

import com.meta.weather.presentation.di.module.weather.WeatherModule
import com.meta.weather.presentation.di.scope.FragmentScope
import com.meta.weather.presentation.ui.weather.WeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [(WeatherModule::class)])
    abstract fun weatherFragment(): WeatherFragment
}