package com.wisal.android.rickandmorty.core.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.wisal.android.rickandmorty.model.CharacterInfo
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class NameUrlConverter {

    @TypeConverter
    fun fromNameUrl(nameUrl: CharacterInfo.NameUrl?): String? {
        return nameUrl?.let {
            Json.encodeToString(it)
        }
    }

    @TypeConverter
    fun toNameUrl(nameUrlString: String?): CharacterInfo.NameUrl? {
        return nameUrlString?.let {
            Json.decodeFromString(it)
        }
    }

}