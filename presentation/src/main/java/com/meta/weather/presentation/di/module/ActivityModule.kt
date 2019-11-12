package com.meta.weather.presentation.di.module

import com.meta.weather.presentation.ui.MainActivity
import com.meta.weather.presentation.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun mainActivity(): MainActivity
}