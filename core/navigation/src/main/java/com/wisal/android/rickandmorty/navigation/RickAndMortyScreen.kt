package com.wisal.android.rickandmorty.navigation

import com.wisal.android.rickandmorty.model.Character
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf


sealed interface RickAndMortyScreen {

    @Serializable
    data object Home: RickAndMortyScreen

    @Serializable
    data class Details(val character: Character): RickAndMortyScreen {
        companion object {
            val typeMap = mapOf(typeOf<Character>() to CharacterType)
        }
    }

}