package com.wisal.android.rickandmorty.data.paging.remotemediator

import android.net.Uri
import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.wisal.android.rickandmorty.core.database.RickAndMortyDatabase
import com.wisal.android.rickandmorty.core.database.entity.CharacterEntity
import com.wisal.android.rickandmorty.core.database.entity.CharacterPageKey
import com.wisal.android.rickandmorty.core.database.entity.mapper.asEntity
import com.wisal.android.rickandmorty.model.Character
import com.wisal.android.rickandmorty.network.service.RickAndMortyClient
import kotlinx.coroutines.delay
import javax.inject.Inject

private const val TAG = "CharacterRemoteMediator"


@OptIn(ExperimentalPagingApi::class)
class CharacterRemoteMediator (
    private val characterApi: RickAndMortyClient,
    private val appDb: RickAndMortyDatabase
    ): RemoteMediator<Int,CharacterEntity>() {

    override suspend fun initialize(): InitializeAction {
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CharacterEntity>
    ): MediatorResult {

        val keyDao = appDb.characterPageKeyDao()

        return try {
            val loadKey = when(loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
//                        ?: return MediatorResult.Success(endOfPaginationReached = true)
//                    lastItem.id
                    val remoteKey: CharacterPageKey? = appDb.withTransaction {
                        if (lastItem?.id != null) {
                            keyDao.getNextPageKey(lastItem.id)
                        } else null
                    }

                    if (remoteKey?.nextPageUrl == null) {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }
                    val uri = Uri.parse(remoteKey.nextPageUrl)
                    val nexPageQuery = uri.getQueryParameter("page")

                    Log.d(TAG,"next page query: $nexPageQuery")

                    nexPageQuery?.toInt()
                }
            }

            val response = characterApi.getAllCharacters(loadKey ?: 1)
            val resBody = response.body()
            val pageInfo = resBody?.pageInfo
            val characters = resBody?.results?.asEntity()

            val characterDao = appDb.characterDao()
            val pageKeyDao = appDb.characterPageKeyDao()

            appDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    characterDao.clearAllCharacter()
                    pageKeyDao.clearAll()
                }

                characters?.forEach {
                    pageKeyDao.insertOrReplace(
                        CharacterPageKey(
                            id = it.id,
                            nextPageUrl = pageInfo?.next
                        )
                    )
                }

                characters?.let {
                    characterDao.insertCharacterList(it)
                }
            }
            MediatorResult.Success(
                endOfPaginationReached = pageInfo?.next == null
            )

        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

}