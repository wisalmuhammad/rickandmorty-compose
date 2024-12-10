package com.wisal.android.rickandmorty.data.di

import com.wisal.android.rickandmorty.data.repository.details.DetailsRepository
import com.wisal.android.rickandmorty.data.repository.details.DetailsRepositoryImp
import com.wisal.android.rickandmorty.data.repository.home.HomeRepository
import com.wisal.android.rickandmorty.data.repository.home.HomeRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindHomeRepository(homeRepositoryImp: HomeRepositoryImp): HomeRepository

    @Binds
    fun bindDetailsRepository(detailsRepository: DetailsRepositoryImp): DetailsRepository

}