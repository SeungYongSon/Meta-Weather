package com.meta.weather.domain.base

import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.DisposableSubscriber

abstract class UseCase<T, E>(private val composite: CompositeDisposable) {

    abstract fun createFlowable(data: E): Flowable<T>

    fun execute(data: E, disposableSubscriber: DisposableSubscriber<T>) {
        val observable = createFlowable(data)

        val observer = observable.subscribeWith(disposableSubscriber)

        composite.add(observer)
    }

    fun clear() = composite.clear()
}