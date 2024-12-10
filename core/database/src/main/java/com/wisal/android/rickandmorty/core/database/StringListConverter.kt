package com.wisal.android.rickandmorty.core.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import kotlinx.serialization.json.Json
import javax.inject.Inject

class StringListConverter {

    @TypeConverter
    fun fromString(value: String): List<String> {
        return value.split(",").map { it }
    }

    @TypeConverter
    fun fromInfoType(value: List<String>): String {
        return value.joinToString(separator = ",")
    }

}