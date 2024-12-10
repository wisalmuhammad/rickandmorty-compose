package com.wisal.android.rickandmorty.network.service

import com.wisal.android.rickandmorty.model.CharacterInfo
import com.wisal.android.rickandmorty.network.model.PagedResponse
import retrofit2.Response
import javax.inject.Inject


class RickAndMortyClient @Inject constructor(
    private val rickAndMortyService: RickAndMortyService
) {
    suspend fun fetchCharacters(): Response<PagedResponse> = rickAndMortyService.fetchCharacters()

    suspend fun getAllCharacters(page: Int): Response<PagedResponse> = rickAndMortyService.getAllCharacters(page)

    suspend fun fetchCharacterInfoById(id: Int): Response<CharacterInfo> = rickAndMortyService.fetchCharacterInfoById(id)

}