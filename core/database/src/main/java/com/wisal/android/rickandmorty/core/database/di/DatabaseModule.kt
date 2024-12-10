package com.wisal.android.rickandmorty.core.database.di

import android.app.Application
import androidx.room.Room
import com.wisal.android.rickandmorty.core.database.CharacterDao
import com.wisal.android.rickandmorty.core.database.CharacterInfoDao
import com.wisal.android.rickandmorty.core.database.CharacterPageKeyDao
import com.wisal.android.rickandmorty.core.database.NameUrlConverter
import com.wisal.android.rickandmorty.core.database.RickAndMortyDatabase
import com.wisal.android.rickandmorty.core.database.StringListConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
        //stringListConverter: StringListConverter,
        //locationTypeConverter: NameUrlConverter
    ): RickAndMortyDatabase {
        return Room
            .databaseBuilder(application, RickAndMortyDatabase::class.java, "rickandmorty.db")
            //.addTypeConverter(stringListConverter)
            //.addTypeConverter(locationTypeConverter)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    }

    @Provides
    @Singleton
    fun provideCharacterDao(
        database: RickAndMortyDatabase
    ): CharacterDao {
        return database.characterDao()
    }

    @Provides
    @Singleton
    fun provideCharacterInfoDao(
        database: RickAndMortyDatabase
    ): CharacterInfoDao {
        return database.characterInfoDao()
    }

    @Provides
    @Singleton
    fun provideCharacterPageKeyDao(
        database: RickAndMortyDatabase
    ): CharacterPageKeyDao = database.characterPageKeyDao()

}