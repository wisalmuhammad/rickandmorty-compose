package com.wisal.android.rickandmorty.data.repository.home

import androidx.annotation.WorkerThread
import androidx.paging.PagingData
import com.wisal.android.rickandmorty.core.database.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    @WorkerThread
    fun getAllCharacters(
        page: Int,
    ): Flow<PagingData<CharacterEntity>>

}