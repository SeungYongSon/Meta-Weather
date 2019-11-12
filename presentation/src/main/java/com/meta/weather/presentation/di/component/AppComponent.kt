package com.meta.weather.presentation.di.component

import com.meta.weather.presentation.di.app.BaseApp
import com.meta.weather.presentation.di.module.ActivityModule
import com.meta.weather.presentation.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (AndroidSupportInjectionModule::class),
        (AppModule::class),
        (ActivityModule::class)
    ]
)
interface AppComponent : AndroidInjector<BaseApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApp): Builder
        fun build(): AppComponent
    }
}