package com.wisal.android.rickandmorty.core.database.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wisal.android.rickandmorty.model.CharacterInfo


//data class Location(
//    val name: String,
//    val url: String
//)
//
//data class Origin(
//    val name: String,
//    val url: String
//)

@Entity
data class CharacterInfoEntity(
    @PrimaryKey val id: Int,
    val created: String,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val location: CharacterInfo.NameUrl,
    val name: String,
    val origin: CharacterInfo.NameUrl,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)