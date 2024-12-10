package com.wisal.android.rickandmorty.data.repository.home

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.wisal.android.rickandmorty.core.database.CharacterDao
import com.wisal.android.rickandmorty.core.database.RickAndMortyDatabase
import com.wisal.android.rickandmorty.core.database.entity.CharacterEntity
import com.wisal.android.rickandmorty.core.database.entity.mapper.asEntity
import com.wisal.android.rickandmorty.data.paging.remotemediator.CharacterRemoteMediator
import com.wisal.android.rickandmorty.model.Character
import com.wisal.android.rickandmorty.network.Dispatcher
import com.wisal.android.rickandmorty.network.RickAndMortyAppDispatchers
import com.wisal.android.rickandmorty.network.service.RickAndMortyClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class HomeRepositoryImp @Inject constructor(
    private val rickAndMortyClient: RickAndMortyClient,
    private val appDb: RickAndMortyDatabase,
    @Dispatcher(RickAndMortyAppDispatchers.IO)
    private val ioDispatcher: CoroutineDispatcher,
) : HomeRepository {

    companion object {
        const val DEFAULT_PAGE_SIZE = 20
    }

    override fun getAllCharacters(
        page: Int,
    ): Flow<PagingData<CharacterEntity>>  {
        return Pager(
            config = PagingConfig(pageSize = DEFAULT_PAGE_SIZE, prefetchDistance = 2),
            remoteMediator = CharacterRemoteMediator(
                characterApi = rickAndMortyClient,
                appDb = appDb
            ),
        ) {
            appDb.characterDao().pagingSource()
        }.flow.flowOn(ioDispatcher)
    }

}