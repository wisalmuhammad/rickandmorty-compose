package com.wisal.android.rickandmorty.data.repository.details

import com.wisal.android.rickandmorty.model.CharacterInfo
import kotlinx.coroutines.flow.Flow

interface DetailsRepository {

    fun fetchPokemonInfo(id: Int, onComplete: () -> Unit, onError: (String?) -> Unit): Flow<CharacterInfo>
}