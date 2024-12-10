package com.wisal.android.rickandmorty.navigation

import android.net.Uri
import android.os.Bundle
import androidx.core.os.BundleCompat
import androidx.navigation.NavType
import com.wisal.android.rickandmorty.model.Character
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


object CharacterType : NavType<Character>(isNullableAllowed = false) {

    override fun put(bundle: Bundle, key: String, value: Character) {
        bundle.putParcelable(key, value)
    }

    override fun get(bundle: Bundle, key: String): Character? =
        BundleCompat.getParcelable(bundle, key, Character::class.java)

    override fun parseValue(value: String): Character {
        return Json.decodeFromString(Uri.decode(value))
    }

    override fun serializeAsValue(value: Character): String = Uri.encode(Json.encodeToString(value))
}