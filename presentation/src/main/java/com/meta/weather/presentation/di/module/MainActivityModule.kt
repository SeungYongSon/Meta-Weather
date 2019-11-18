package com.meta.weather.presentation.di.module

import com.meta.weather.presentation.di.module.weather.WeatherStaticModule
import com.meta.weather.presentation.di.scope.FragmentScope
import com.meta.weather.presentation.ui.fragment.weather.WeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [(WeatherStaticModule::class)])
    abstract fun weatherFragment(): WeatherFragment
}