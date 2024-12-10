package com.wisal.android.rickandmorty.network.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

//sealed interface ApiResponse<out T> {
//    data class Success<T>(val data: T) : ApiResponse<T>
//    data class Failure<T>(val ex: Exception) : ApiResponse<T>
//    data object Loading: ApiResponse<Nothing>
//}