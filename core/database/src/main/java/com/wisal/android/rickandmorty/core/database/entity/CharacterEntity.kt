package com.wisal.android.rickandmorty.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val image: String,
)