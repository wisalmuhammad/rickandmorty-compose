package com.wisal.android.rickandmorty.network

import javax.inject.Qualifier

enum class RickAndMortyAppDispatchers {
    IO
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val rickAndMortyAppDispatchers: RickAndMortyAppDispatchers)