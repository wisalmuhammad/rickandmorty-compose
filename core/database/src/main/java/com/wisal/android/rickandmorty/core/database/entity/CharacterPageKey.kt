package com.wisal.android.rickandmorty.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CharacterPageKey(
    @PrimaryKey val id: Int,
    val nextPageUrl: String?
)