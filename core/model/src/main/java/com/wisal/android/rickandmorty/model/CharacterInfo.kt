package com.wisal.android.rickandmorty.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//@Serializable
//data class Location(
//    val name: String,
//    val url: String
//)
//
//@Serializable
//data class Origin(
//    val name: String,
//    val url: String
//)

@Immutable
@Serializable
data class CharacterInfo(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterInfo.NameUrl,
    val name: String,
    val origin: CharacterInfo.NameUrl,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    @Serializable
    data class NameUrl(
        @SerialName(value = "name") val name: String,
        @SerialName(value = "url") val url: String
    )
}