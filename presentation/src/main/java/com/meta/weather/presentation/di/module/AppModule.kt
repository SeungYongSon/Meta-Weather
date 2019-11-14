package com.meta.weather.presentation.di.module

import android.app.Application
import android.content.Context
import com.meta.weather.presentation.di.app.BaseApp
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module(includes = [(NetworkModule::class)])
class AppModule {
    @Singleton
    @Provides
    fun provideContext(application: BaseApp): Context = application

    @Singleton
    @Provides
    fun provideApplication(app: BaseApp): Application = app

    @Singleton
    @Provides
    fun provideComposite(): CompositeDisposable = CompositeDisposable()
}