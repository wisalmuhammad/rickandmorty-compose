package com.wisal.android.rickandmorty.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Immutable
@Parcelize
@Serializable
data class Character(
    @SerialName(value = "id") val id: Int = 0,
    @SerialName(value = "image")val image: String,
    @SerialName(value = "name") val name: String,
) : Parcelable