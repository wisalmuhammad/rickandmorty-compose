package com.wisal.android.rickandmorty.network.model

import com.wisal.android.rickandmorty.model.Character
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Info(
    @SerialName(value = "count") val count: Int,
    @SerialName(value = "next")val next: String?,
    @SerialName(value = "pages")val pages: Int,
    @SerialName(value = "prev") val prev: String?
)

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
//
//@Serializable
//data class Result(
////    val created: String,
////    val episode: List<String>,
////    val gender: String,
// @SerialName(value = "id") val id: Int,
// @SerialName(value = "image") val image: String,
////    val location: Location,
// @SerialName(value = "id") val name: String,
////    val origin: Origin,
////    val species: String,
////    val status: String,
////    val type: String,
////    val url: String
//)

@Serializable
data class PagedResponse(
    @SerialName(value = "info") val pageInfo: Info,
    @SerialName(value = "results") val results: List<Character>
)