package com.meta.weather.domain.base

interface Mapper<in T, E> {
    fun mapFrom(from: T): E
}