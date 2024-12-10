package com.wisal.android.rickandmorty.network.service

import com.wisal.android.rickandmorty.model.CharacterInfo
import com.wisal.android.rickandmorty.network.model.PagedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("character/")
    suspend fun fetchCharacters(
        @Query("page") page: Int = 1
    ): Response<PagedResponse>

    @GET("character/")
    suspend fun getAllCharacters(
        @Query("page") page: Int = 1
    ): Response<PagedResponse>

    @GET("character/{id}")
    suspend fun fetchCharacterInfoById(
        @Path("id") id: Int
    ): Response<CharacterInfo>

}