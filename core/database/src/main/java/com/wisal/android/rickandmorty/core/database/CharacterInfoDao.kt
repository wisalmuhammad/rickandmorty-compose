package com.wisal.android.rickandmorty.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wisal.android.rickandmorty.core.database.entity.CharacterInfoEntity

@Dao
interface CharacterInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterInfo(charactersInfo: CharacterInfoEntity)

    @Query("SELECT * FROM CharacterInfoEntity WHERE id =:id")
    suspend fun getCharacterInfo(id: Int): CharacterInfoEntity?

}