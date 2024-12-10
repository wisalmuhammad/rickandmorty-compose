package com.wisal.android.rickandmorty.network.di

import com.wisal.android.rickandmorty.network.Dispatcher
import com.wisal.android.rickandmorty.network.RickAndMortyAppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


@Module
@InstallIn(SingletonComponent::class)
internal object DispatcherModule {

    @Provides
    @Dispatcher(RickAndMortyAppDispatchers.IO)
    fun provideDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

}