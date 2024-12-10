package com.wisal.android.rickandmorty.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wisal.android.rickandmorty.core.database.entity.CharacterPageKey


@Dao
interface CharacterPageKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(pageKey: CharacterPageKey)

    @Query("SELECT * FROM characterpagekey WHERE id LIKE :id")
    fun getNextPageKey(id: Int): CharacterPageKey?

    @Query("DELETE FROM CharacterPageKey")
    suspend fun clearAll()
}