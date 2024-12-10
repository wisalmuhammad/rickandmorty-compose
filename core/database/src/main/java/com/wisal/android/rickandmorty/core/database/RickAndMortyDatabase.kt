package com.wisal.android.rickandmorty.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.wisal.android.rickandmorty.core.database.entity.CharacterEntity
import com.wisal.android.rickandmorty.core.database.entity.CharacterInfoEntity
import com.wisal.android.rickandmorty.core.database.entity.CharacterPageKey


@Database(
    entities = [CharacterEntity::class, CharacterInfoEntity::class,CharacterPageKey::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(NameUrlConverter::class,StringListConverter::class)
abstract class RickAndMortyDatabase: RoomDatabase() {

    abstract fun characterDao(): CharacterDao
    abstract fun characterInfoDao(): CharacterInfoDao
    abstract fun characterPageKeyDao(): CharacterPageKeyDao

}